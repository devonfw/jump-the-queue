package com.cap.jumpthequeue.general.visitorinfomanagement.logic.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.jumpthequeue.SpringBootApp;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.Visitorinfomanagement;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoEto;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author machamou
 *
 */
@SpringBootTest(classes = SpringBootApp.class)
public class VisitorinfomanagementTest extends ComponentTest {

  @Autowired
  private Visitorinfomanagement visitorinfomanagement;

  VisitorInfoEto visitorInfo = new VisitorInfoEto();

  VisitorInfoSearchCriteriaTo criteria = new VisitorInfoSearchCriteriaTo();

  @Override
  public void doSetUp() {

    this.visitorInfo.setName("Test");
    this.visitorInfo.setPhone("1234 444");
    this.visitorInfo.setEmail("Test@mail.com");
    this.visitorInfo.setQueueId((long) 2);
  }

  @Test
  public void saveVisitorInfoTest() {

    VisitorInfoEto result = this.visitorinfomanagement.saveVisitorInfo(this.visitorInfo);

    assertThat(result).isNotNull();
    assertThat(result.getName() == "Test");
    assertThat(result.getPhone() == "1234 444");
    assertThat(result.getEmail() == "Test@mail.com");
    assertThat(result.getQueueId() == 2);
  }

  @Test
  public void findVisitorInfoEtosTest() {

    PaginatedListTo<VisitorInfoEto> result = this.visitorinfomanagement.findVisitorInfoEtos(this.criteria);
    assertThat(result).isNotNull();
  }

  @Test
  public void findVisitorInfoTest() {

    VisitorInfoEto result = this.visitorinfomanagement.findVisitorInfo((long) 1);
    assertThat(result).isNotNull();
    assertThat(result.getId() == 1);
  }

  /*
   * Can make this test? Order o conditional?
   *
   * @Test public void deleteVisitorInfoTest() {
   *
   * this.visitorinfomanagement.deleteVisitorInfo((long) 1); VisitorInfoEto result =
   * this.visitorinfomanagement.findVisitorInfo((long) 1); assertThat(result).isNull();
   *
   * }
   */
}
