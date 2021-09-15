package com.devonfw.application.jtqj.general.service.impl.config;

import javax.inject.Inject;
import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.devonfw.application.jtqj.general.common.base.AdvancedDaoAuthenticationProvider;
import com.devonfw.module.security.common.api.config.WebSecurityConfigurer;
import com.devonfw.module.security.common.impl.rest.AuthenticationSuccessHandlerSendingOkHttpStatusCode;
import com.devonfw.module.security.common.impl.rest.JsonUsernamePasswordAuthenticationFilter;
import com.devonfw.module.security.common.impl.rest.LogoutSuccessHandlerReturningOkHttpStatusCode;

/**
 * This type serves as a base class for extensions of the {@code WebSecurityConfigurerAdapter} and provides a default
 * configuration. <br/>
 * Security configuration is based on {@link WebSecurityConfigurerAdapter}. This configuration is by purpose designed
 * most simple for two channels of authentication: simple login form and rest-url.
 */
public abstract class BaseWebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Inject
  private UserDetailsService userDetailsService;

  @Inject
  private PasswordEncoder passwordEncoder;

  @Inject
  private WebSecurityConfigurer webSecurityConfigurer;

  /**
   * Configure spring security to enable a simple webform-login + a simple rest login.
   */
  @Override
  public void configure(HttpSecurity http) throws Exception {

    String[] unsecuredResources = new String[] { "/login", "/security/**", "/services/rest/login",
    "/services/rest/logout", "/services/rest/visitormanagement/v1/visitor" };

    // disable CSRF protection by default, use csrf starter to override.
    http = http.csrf().disable();
    // load starters as pluggins.
    http = this.webSecurityConfigurer.configure(http);

    http.userDetailsService(this.userDetailsService).exceptionHandling().and().sessionManagement().and()
        .authorizeRequests().antMatchers(unsecuredResources).permitAll().antMatchers(HttpMethod.POST, "/login")
        .permitAll().anyRequest().authenticated().and()
        .addFilterAfter(getSimpleRestAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
  }

  /**
   * Create a simple filter that allows logout on a REST Url /services/rest/logout and returns a simple HTTP status 200
   * ok.
   *
   * @return the filter.
   */
  protected Filter getSimpleRestLogoutFilter() {

    LogoutFilter logoutFilter = new LogoutFilter(new LogoutSuccessHandlerReturningOkHttpStatusCode(),
        new SecurityContextLogoutHandler());

    // configure logout for rest logouts
    logoutFilter.setLogoutRequestMatcher(new AntPathRequestMatcher("/services/rest/logout"));

    return logoutFilter;
  }

  /**
   * Create a simple authentication filter for REST logins that reads user-credentials from a json-parameter and returns
   * status 200 instead of redirect after login.
   *
   * @return the {@link JsonUsernamePasswordAuthenticationFilter}.
   * @throws Exception if something goes wrong.
   */
  protected JsonUsernamePasswordAuthenticationFilter getSimpleRestAuthenticationFilter() throws Exception {

    JsonUsernamePasswordAuthenticationFilter jsonFilter = new JsonUsernamePasswordAuthenticationFilter(
        new AntPathRequestMatcher("/services/rest/login"));
    jsonFilter.setPasswordParameter("password");
    jsonFilter.setUsernameParameter("username");
    jsonFilter.setAuthenticationManager(authenticationManager());
    // set failurehandler that uses no redirect in case of login failure; just HTTP-status: 401
    jsonFilter.setAuthenticationManager(authenticationManagerBean());
    jsonFilter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler());
    // set successhandler that uses no redirect in case of login success; just HTTP-status: 200
    jsonFilter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandlerSendingOkHttpStatusCode());
    return jsonFilter;
  }

  @Inject
  private AdvancedDaoAuthenticationProvider advancedDaoAuthenticationProvider;

  @Bean
  public AdvancedDaoAuthenticationProvider advancedDaoAuthenticationProvider() {

    AdvancedDaoAuthenticationProvider authProvider = new AdvancedDaoAuthenticationProvider();
    authProvider.setPasswordEncoder(this.passwordEncoder);
    authProvider.setUserDetailsService(this.userDetailsService);
    return authProvider;
  }

  @SuppressWarnings("javadoc")
  @Override
  // public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.authenticationProvider(this.advancedDaoAuthenticationProvider);
    // auth.inMemoryAuthentication().withUser("admin@cg.com").password(this.passwordEncoder.encode("admin"))
    // .roles("Admin");
  }

}
