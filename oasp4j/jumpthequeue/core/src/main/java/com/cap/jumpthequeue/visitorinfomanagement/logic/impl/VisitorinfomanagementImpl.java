package com.cap.jumpthequeue.visitorinfomanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;
import com.cap.jumpthequeue.visitorinfomanagement.dataaccess.api.VisitorInfoEntity;
import com.cap.jumpthequeue.visitorinfomanagement.dataaccess.api.dao.VisitorInfoDao;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.Visitorinfomanagement;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoEto;
import com.cap.jumpthequeue.visitorinfomanagement.logic.api.to.VisitorInfoSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of visitorinfomanagement
 */
@Named
@Transactional
public class VisitorinfomanagementImpl extends AbstractComponentFacade implements Visitorinfomanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(VisitorinfomanagementImpl.class);

  /** @see #getVisitorInfoDao() */
  @Inject
  private VisitorInfoDao visitorInfoDao;

  /**
   * The constructor.
   */
  public VisitorinfomanagementImpl() {
    super();
  }

  @Override
  public VisitorInfoEto findVisitorInfo(Long id) {

    LOG.debug("Get VisitorInfo with id {} from database.", id);
    return getBeanMapper().map(getVisitorInfoDao().findOne(id), VisitorInfoEto.class);
  }

  @Override
  public PaginatedListTo<VisitorInfoEto> findVisitorInfoEtos(VisitorInfoSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<VisitorInfoEntity> visitorinfos = getVisitorInfoDao().findVisitorInfos(criteria);
    return mapPaginatedEntityList(visitorinfos, VisitorInfoEto.class);
  }

  @Override
  public boolean deleteVisitorInfo(Long visitorInfoId) {

    VisitorInfoEntity visitorInfo = getVisitorInfoDao().find(visitorInfoId);
    getVisitorInfoDao().delete(visitorInfo);
    LOG.debug("The visitorInfo with id '{}' has been deleted.", visitorInfoId);
    return true;
  }

  @Override
  public VisitorInfoEto saveVisitorInfo(VisitorInfoEto visitorInfo) {

    Objects.requireNonNull(visitorInfo, "visitorInfo");
    VisitorInfoEntity visitorInfoEntity = getBeanMapper().map(visitorInfo, VisitorInfoEntity.class);

    // initialize, validate visitorInfoEntity here if necessary
    VisitorInfoEntity resultEntity = getVisitorInfoDao().save(visitorInfoEntity);
    LOG.debug("VisitorInfo with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, VisitorInfoEto.class);
  }

  /**
   * Returns the field 'visitorInfoDao'.
   * 
   * @return the {@link VisitorInfoDao} instance.
   */
  public VisitorInfoDao getVisitorInfoDao() {

    return this.visitorInfoDao;
  }

}