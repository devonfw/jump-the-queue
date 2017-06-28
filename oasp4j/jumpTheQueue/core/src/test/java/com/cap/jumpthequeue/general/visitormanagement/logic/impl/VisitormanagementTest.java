package com.cap.jumpthequeue.general.visitormanagement.logic.impl;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cap.jumpthequeue.SpringBootApp;
import com.cap.jumpthequeue.visitormanagement.logic.api.Visitormanagement;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorCto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

@SpringApplicationConfiguration(classes = SpringBootApp.class)
@WebAppConfiguration
public class VisitormanagementTest extends ComponentTest {

  @Inject
  private Visitormanagement visitormanagement;

  VisitorEto visitor = new VisitorEto();

  VisitorSearchCriteriaTo criteria = new VisitorSearchCriteriaTo();

  @Override
  public void doSetUp() {

    this.visitor.setName("Mary");
    this.visitor.setEmail("mary@mail.com");
    this.visitor.setPhone("123456789");
  }

  @Test
  public void registerVisitorTest() {

    VisitorCto result = this.visitormanagement.registerVisitor(this.visitor);
    assertThat(result).isNotNull();
    assertThat(result.getVisitor().getName()).isEqualTo("Mary");
    assertThat(result.getCode().getCode()).isNotEmpty();
  }

  @Test
  public void listVisitorsTest() {

    PaginatedListTo<VisitorCto> result = this.visitormanagement.findVisitorCtos(this.criteria);
    assertThat(result).isNotNull();
  }
}
