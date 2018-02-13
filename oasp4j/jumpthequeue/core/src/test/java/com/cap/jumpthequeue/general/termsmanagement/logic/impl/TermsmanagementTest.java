package com.cap.jumpthequeue.general.termsmanagement.logic.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.jumpthequeue.SpringBootApp;
import com.cap.jumpthequeue.termsmanagement.logic.api.Termsmanagement;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsEto;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author machamou
 *
 */
@SpringBootTest(classes = SpringBootApp.class)
public class TermsmanagementTest extends ComponentTest {

  @Autowired
  private Termsmanagement termsmanagement;

  TermsEto terms = new TermsEto();

  TermsSearchCriteriaTo criteria = new TermsSearchCriteriaTo();

  @Override
  public void doSetUp() {

    this.terms.setDescription("Test");
    this.terms.setQueueId((long) 2);
  }

  @Test
  public void saveTermsTest() {

    TermsEto result = this.termsmanagement.saveTerms(this.terms);

    assertThat(result).isNotNull();
    assertThat(result.getDescription().equals("Test"));
    assertThat(result.getQueueId().equals(2));
  }

  @Test
  public void findTermsEtosTest() {

    PaginatedListTo<TermsEto> result = this.termsmanagement.findTermsEtos(this.criteria);
    assertThat(result).isNotNull();
  }

  @Test
  public void findVisitorInfoTest() {

    TermsEto result = this.termsmanagement.findTerms((long) 1);
    assertThat(result).isNotNull();
    assertThat(result.getId() == 1);
  }

  @Test
  public void modifTermsTest() {

    this.terms.setId((long) 2);
    TermsEto modif = new TermsEto();
    modif.setDescription("Test modif");
    this.termsmanagement.modifTerms(2, modif);
    assertThat(this.terms).isNotNull();
    assertThat(this.terms.getDescription().equals("Test modif"));
  }

  /*
   * Can make this test? Need Queue for this
   *
   * @Test public void getTermsByQueueIdTest() {
   *
   * TermsEto result = this.termsmanagement.getTermsByQueueId(2); assertThat(result).isNotNull();
   * assertThat(result.getQueueId().equals(2)); }
   */
}
