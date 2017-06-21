package com.cap.jumpthequeue.accesscode.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.accesscode.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscode.dataaccess.api.dao.AccessCodeDao;
import com.cap.jumpthequeue.accesscode.logic.api.Accesscode;
import com.cap.jumpthequeue.accesscode.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscode.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of accesscode
 */
@Named
@Transactional
public class AccesscodeImpl extends AbstractComponentFacade implements Accesscode {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(AccesscodeImpl.class);

  /** @see #getAccessCodeDao() */
  @Inject
  private AccessCodeDao accessCodeDao;

  /**
   * The constructor.
   */
  public AccesscodeImpl() {
    super();
  }

  @Override
  public AccessCodeEto findAccessCode(Long id) {

    LOG.debug("Get AccessCode with id {} from database.", id);
    return getBeanMapper().map(getAccessCodeDao().findOne(id), AccessCodeEto.class);
  }

  @Override
  public PaginatedListTo<AccessCodeEto> findAccessCodeEtos(AccessCodeSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<AccessCodeEntity> accesscodes = getAccessCodeDao().findAccessCodes(criteria);
    return mapPaginatedEntityList(accesscodes, AccessCodeEto.class);
  }

  @Override
  public boolean deleteAccessCode(Long accessCodeId) {

    AccessCodeEntity accessCode = getAccessCodeDao().find(accessCodeId);
    getAccessCodeDao().delete(accessCode);
    LOG.debug("The accessCode with id '{}' has been deleted.", accessCodeId);
    return true;
  }

  @Override
  public AccessCodeEto saveAccessCode(AccessCodeEto accessCode) {

    Objects.requireNonNull(accessCode, "accessCode");
    AccessCodeEntity accessCodeEntity = getBeanMapper().map(accessCode, AccessCodeEntity.class);

    // initialize, validate accessCodeEntity here if necessary
    getAccessCodeDao().save(accessCodeEntity);
    LOG.debug("AccessCode with id '{}' has been created.", accessCodeEntity.getId());

    return getBeanMapper().map(accessCodeEntity, AccessCodeEto.class);
  }

  /**
   * Returns the field 'accessCodeDao'.
   *
   * @return the {@link AccessCodeDao} instance.
   */
  public AccessCodeDao getAccessCodeDao() {

    return this.accessCodeDao;
  }

}