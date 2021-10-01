package com.devonfw.application.jtqj.general.common.base;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import com.devonfw.application.jtqj.visitormanagement.dataaccess.api.VisitorEntity;
import com.devonfw.application.jtqj.visitormanagement.dataaccess.api.repo.VisitorRepository;

/*import com.devon.application.testapp1.usermanagement.dataaccess.api.UserEntity;
import com.devon.application.testapp1.usermanagement.dataaccess.api.repo.UserRepository;
*/
public class AdvancedDaoAuthenticationProvider extends DaoAuthenticationProvider {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AdvancedDaoAuthenticationProvider.class);

  @Inject
  private VisitorRepository userRepository;

  private PasswordEncoder passwordEncoder;

  public AdvancedDaoAuthenticationProvider() {

    this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Override
  public Authentication authenticate(Authentication auth) throws AuthenticationException {

    List<VisitorEntity> users = this.userRepository.findByUsername(auth.getName());
    if (users.size() == 0) {
      throw new BadCredentialsException("Credentials are invalid");
    }

    VisitorEntity user = users.get(0);

    if (auth.getCredentials() == null) {
      LOG.debug("Authentication failed: no credentials provided");

      throw new BadCredentialsException("Credentials are invalid");
    }

    String presentedPassword = auth.getCredentials().toString();

    // if (!this.passwordEncoder.matches(presentedPassword, user.getPassword())) {
    if (!presentedPassword.equals(user.getPassword())) {
      LOG.debug("Authentication failed: password does not match stored value");

      throw new BadCredentialsException("Credentials are invalid");
    }

    LOG.debug("Basic Authentication was successful");
    return populateSuccessUsernamePasswordAuthentication(auth, "None");
  }

  @Override
  public void setPasswordEncoder(PasswordEncoder passwordEncoder) {

    Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void setUserDetailsService(UserDetailsService userDetailsService) {

    super.setUserDetailsService(userDetailsService);
  }

  private Authentication populateSuccessUsernamePasswordAuthentication(Authentication auth, Object factor) {

    UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(auth.getPrincipal(),
        auth.getCredentials(), TokenAuthenticationService.getRolesFromName(auth));

    result.setDetails(factor);

    return result;
  }

  @Override
  public boolean supports(Class<?> authentication) {

    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
}
