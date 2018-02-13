package com.cap.jumpthequeue.general.ownermanagement.logic.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.jumpthequeue.SpringBootApp;
import com.cap.jumpthequeue.ownermanagement.logic.api.Ownermanagement;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerEto;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author machamou
 *
 */
@SpringBootTest(classes = SpringBootApp.class)
public class OwnermanagementTest extends ComponentTest {

  @Autowired
  private Ownermanagement ownermanagement;

  OwnerEto owner = new OwnerEto();

  OwnerSearchCriteriaTo criteria = new OwnerSearchCriteriaTo();

  @Override
  public void doSetUp() {

    this.owner.setName("Test");
    this.owner.setEmail("Test@mail.com");
    this.owner.setPassword("Testpass");
  }

  @Test
  public void findOwnerTest() {

    OwnerEto result = this.ownermanagement.findOwner((long) 1);
    assertThat(result).isNotNull();
    assertThat(result.getId() == 1);
  }

  @Test
  public void findOwnerEtosTest() {

    PaginatedListTo<OwnerEto> result = this.ownermanagement.findOwnerEtos(this.criteria);
    assertThat(result).isNotNull();
  }

  @Test
  public void saveOwnerTest() {

    OwnerEto result = this.ownermanagement.saveOwner(this.owner);

    assertThat(result).isNotNull();
    assertThat(result.getName().equals("Test"));
    assertThat(result.getEmail().equals(this.owner.getEmail()));
    assertThat(result.getPassword().equals(this.owner.getPassword()));
  }

}
