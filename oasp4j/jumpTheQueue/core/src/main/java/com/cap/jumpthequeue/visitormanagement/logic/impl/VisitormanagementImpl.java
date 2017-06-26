package com.cap.jumpthequeue.visitormanagement.logic.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.Accesscodemanagement;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
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
  private Accesscodemanagement accesscode;

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
  public VisitorCto saveVisitorAndGetCode(VisitorEto visitor) {

    // Objects.requireNonNull(visitor, "visitor");
    // VisitorEntity visitorEntity = getBeanMapper().map(visitor, VisitorEntity.class);
    // // initialize, validate visitorEntity here if necessary
    // AccessCodeEto codeEto = new AccessCodeEto();
    // codeEto.setVisitorId(visitorEntity.getId());
    // AccessCodeEntity code = getBeanMapper().map(this.accesscode.saveAccessCode(codeEto), AccessCodeEntity.class);
    // visitorEntity.setCode(code);
    // getVisitorDao().save(visitorEntity);
    //
    // VisitorCto visitorCto = new VisitorCto();
    // visitorCto.setCode(getBeanMapper().map(code, AccessCodeEto.class));
    // visitorCto.setVisitor(getBeanMapper().map(visitorEntity, VisitorEto.class));
    // LOG.debug("Visitor with id '{}' has been created.", visitorEntity.getId());
    //
    // return visitorCto;

    Objects.requireNonNull(visitor, "visitor");
    VisitorEntity visitorEntity = getBeanMapper().map(visitor, VisitorEntity.class);
    // initialize, validate visitorEntity here if necessary
    AccessCodeEntity code = new AccessCodeEntity();
    code.setCode(generateCode(new Random(), 3));
    code.setDateAndTime(Timestamp.from(Instant.now()));
    visitorEntity.setCode(code);
    VisitorEntity savedVisitor = getVisitorDao().save(visitorEntity);

    VisitorCto cto = new VisitorCto();
    cto.setVisitor(getBeanMapper().map(savedVisitor, VisitorEto.class));
    cto.setCode(getBeanMapper().map(this.accesscode.findAccessCode(savedVisitor.getCodeId()), AccessCodeEto.class));
    return cto;
  }

  /**
   * Returns the field 'visitorDao'.
   *
   * @return the {@link VisitorDao} instance.
   */
  public VisitorDao getVisitorDao() {

    return this.visitorDao;
  }

  private static String generateCode(Random rng, int length) {

    String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    char[] text = new char[length];
    for (int i = 0; i < length; i++) {
      text[i] = characters.charAt(rng.nextInt(characters.length()));
    }
    return new String(text);
  }

}