package com.cap.jumpthequeue.termsmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;

import com.cap.jumpthequeue.termsmanagement.logic.api.Termsmanagement;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsEto;
import com.cap.jumpthequeue.termsmanagement.logic.api.to.TermsSearchCriteriaTo;
import com.cap.jumpthequeue.termsmanagement.service.api.rest.TermsmanagementRestService;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service implementation for REST calls in order to execute the logic of component {@link Termsmanagement}.
 */
@Named("TermsmanagementRestService")
public class TermsmanagementRestServiceImpl implements TermsmanagementRestService {

  @Inject
  private Termsmanagement termsmanagement;

  @Override
  public TermsEto getTerms(long id) {

    return this.termsmanagement.findTerms(id);
  }

  @Override
  public TermsEto saveTerms(TermsEto terms) {

    return this.termsmanagement.saveTerms(terms);
  }

  @Override
  public void deleteTerms(long id) {

    this.termsmanagement.deleteTerms(id);
  }

  @Override
  public PaginatedListTo<TermsEto> findTermssByPost(TermsSearchCriteriaTo searchCriteriaTo) {

    return this.termsmanagement.findTermsEtos(searchCriteriaTo);
  }

  @Override
  public TermsEto getTermsByQueueId(long queueid) {

    return this.termsmanagement.getTermsByQueueId(queueid);

  }

  @Override
  public TermsEto modifTerms(long id, TermsEto newterms) {

    return this.termsmanagement.modifTerms(id, newterms);
  }

}