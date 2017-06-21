package com.cap.jumpthequeue.visitormanagement.logic.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.accesscode.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscode.logic.api.Accesscode;
import com.cap.jumpthequeue.accesscode.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;
import com.cap.jumpthequeue.visitormanagement.dataaccess.api.VisitorEntity;
import com.cap.jumpthequeue.visitormanagement.dataaccess.api.dao.VisitorDao;
import com.cap.jumpthequeue.visitormanagement.logic.api.Visitormanagement;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorCto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of visitormanagement
 */
@Named
@Transactional
public class VisitormanagementImpl extends AbstractComponentFacade implements Visitormanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(VisitormanagementImpl.class);

  /** @see #getVisitorDao() */
  @Inject
  private VisitorDao visitorDao;

  @Inject
  private Accesscode accesscode;

  /**
   * The constructor.
   */
  public VisitormanagementImpl() {
    super();
  }

  @Override
  public VisitorEto findVisitor(Long id) {

    LOG.debug("Get Visitor with id {} from database.", id);
    return getBeanMapper().map(getVisitorDao().findOne(id), VisitorEto.class);
  }

  @Override
  public PaginatedListTo<VisitorCto> findVisitorCtos(VisitorSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<VisitorEntity> visitors = getVisitorDao().findVisitors(criteria);
    List<VisitorCto> ctos = new ArrayList<>();
    for (VisitorEntity entity : visitors.getResult()) {
      VisitorCto cto = new VisitorCto();
      cto.setVisitor(getBeanMapper().map(entity, VisitorEto.class));
      cto.setCode(this.accesscode.findAccessCode(entity.getId()));
      ctos.add(cto);
    }
    return new PaginatedListTo<>(ctos, visitors.getPagination());
  }

  @Override
  public boolean deleteVisitor(Long visitorId) {

    VisitorEntity visitor = getVisitorDao().find(visitorId);
    getVisitorDao().delete(visitor);
    LOG.debug("The visitor with id '{}' has been deleted.", visitorId);
    return true;
  }

  @Override
  public VisitorEto saveVisitor(VisitorEto visitor) {

    Objects.requireNonNull(visitor, "visitor");
    VisitorEntity visitorEntity = getBeanMapper().map(visitor, VisitorEntity.class);

    // initialize, validate visitorEntity here if necessary
    AccessCodeEntity code = new AccessCodeEntity();
    code.setCode("A34");
    code.setDateAndTime(Timestamp.from(Instant.now()));
    visitorEntity.setCode(code);
    getVisitorDao().save(visitorEntity);

    LOG.debug("Visitor with id '{}' has been created.", visitorEntity.getId());

    return getBeanMapper().map(visitorEntity, VisitorEto.class);
  }

  @Override
  public AccessCodeEto saveVisitorAndGetCode(VisitorEto visitor) {

    Objects.requireNonNull(visitor, "visitor");
    VisitorEntity visitorEntity = getBeanMapper().map(visitor, VisitorEntity.class);
    // initialize, validate visitorEntity here if necessary
    AccessCodeEntity code = new AccessCodeEntity();
    code.setCode("A34");
    code.setDateAndTime(Timestamp.from(Instant.now()));
    visitorEntity.setCode(code);
    VisitorEntity savedVisitor = getVisitorDao().save(visitorEntity);
    return this.accesscode.findAccessCode(savedVisitor.getCodeId());
  }

  /**
   * Returns the field 'visitorDao'.
   *
   * @return the {@link VisitorDao} instance.
   */
  public VisitorDao getVisitorDao() {

    return this.visitorDao;
  }

}