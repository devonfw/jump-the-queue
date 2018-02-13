package com.cap.jumpthequeue.general.usermanagement.logic.impl;

import java.sql.Timestamp;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.jumpthequeue.SpringBootApp;
import com.cap.jumpthequeue.usermanagement.logic.api.Usermanagement;
import com.cap.jumpthequeue.usermanagement.logic.api.to.UserEto;
import com.cap.jumpthequeue.usermanagement.logic.api.to.UserSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author machamou
 *
 */
@SpringBootTest(classes = SpringBootApp.class)
public class UsermanagementTest extends ComponentTest {
  @Autowired
  private Usermanagement usermanagement;

  UserEto user = new UserEto();

  UserSearchCriteriaTo criteria = new UserSearchCriteriaTo();

  @Override
  public void doSetUp() {

    this.user.setName("Test");
    this.user.setEmail("Test@mail.com");
    this.user.setPhone("1234");
    this.user.setUrl("www.testweb.com");
    this.user.setCreationTime(Timestamp.valueOf("2017-12-12 20:00:00"));
    this.user.setConsent(false);
    this.user.setQueueId((long) 2);
  }

  @Test
  public void findUserEtosTest() {

    PaginatedListTo<UserEto> result = this.usermanagement.findUserEtos(this.criteria);
    assertThat(result).isNotNull();
  }

  @Test
  public void findUserTest() {

    UserEto result = this.usermanagement.findUser((long) 1);
    assertThat(result).isNotNull();
    assertThat(result.getId() == 1);
  }

  @Test
  public void saveUserTest() {

    UserEto result = this.usermanagement.saveUser(this.user);
    assertThat(result).isNotNull();

    assertThat(result.getName() == "Test");
    assertThat(result.getEmail() == "Test@mail.com");
    assertThat(result.getPhone() == "1234");
    assertThat(result.getUrl() == "www.testweb.com");
    assertThat(!result.getIdentificator().isEmpty());
    assertThat(result.getConsent() == false);
    assertThat(result.getQueueId() == 2);
    assertThat(!result.getToken().isEmpty());
  }

}
