package com.cap.jumpthequeue.visitormanagement.logic.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.Accesscodemanagement;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;
import com.cap.jumpthequeue.visitormanagement.dataaccess.api.VisitorEntity;
import com.cap.jumpthequeue.visitormanagement.dataaccess.api.dao.VisitorDao;
import com.cap.jumpthequeue.visitormanagement.logic.api.Visitormanagement;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorCto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorEto;
import com.cap.jumpthequeue.visitormanagement.logic.api.to.VisitorSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.OrderByTo;
import io.oasp.module.jpa.common.api.to.OrderDirection;
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
  public VisitorCto saveVisitor(VisitorEto visitor) {

    Objects.requireNonNull(visitor, "visitor");
    VisitorEntity visitorEntity = getBeanMapper().map(visitor, VisitorEntity.class);

    // initialize, validate visitorEntity here if necessary
    AccessCodeEto codeEto = new AccessCodeEto();
    codeEto.setVisitorId(visitorEntity.getId());
    AccessCodeEntity code = getBeanMapper().map(this.accesscode.saveAccessCode(codeEto), AccessCodeEntity.class);
    visitorEntity.setCode(code);
    getVisitorDao().save(visitorEntity);

    VisitorCto visitorCto = new VisitorCto();
    visitorCto.setCode(getBeanMapper().map(code, AccessCodeEto.class));
    visitorCto.setVisitor(getBeanMapper().map(visitorEntity, VisitorEto.class));
    LOG.debug("Visitor with id '{}' has been created.", visitorEntity.getId());

    return visitorCto;
  }

  @Override
  public PaginatedListTo<QueueEto> queuedVisitors() {

    AccessCodeSearchCriteriaTo criteria = new AccessCodeSearchCriteriaTo();
    List<OrderByTo> order = new ArrayList<>();
    OrderByTo dateOrder = new OrderByTo();
    dateOrder.setName("dateAndTime");
    dateOrder.setDirection(OrderDirection.ASC);
    order.add(dateOrder);
    criteria.setSort(order);
    List<QueueEto> queue = new ArrayList<>();
    PaginatedListTo<AccessCodeEto> accessCodes = this.accesscode.findAccessCodeEtos(criteria);
    accessCodes.getResult().forEach(code -> {
      QueueEto queueEntry = new QueueEto();
      queueEntry.setName(findVisitor(code.getVisitorId()).getName());
      queueEntry.setSurname(findVisitor(code.getVisitorId()).getSurname());
      queueEntry.setDateAndTime(code.getDateAndTime());
      queue.add(queueEntry);
    });

    return new PaginatedListTo<>(queue, accessCodes.getPagination());
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