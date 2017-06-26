package com.cap.jumpthequeue.accesscodemanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.dao.AccessCodeDao;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.Accesscodemanagement;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of accesscode
 */
@Named
@Transactional
public class AccesscodemanagementImpl extends AbstractComponentFacade implements Accesscodemanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(AccesscodemanagementImpl.class);

  /** @see #getAccessCodeDao() */
  @Inject
  private AccessCodeDao accessCodeDao;

  /**
   * The constructor.
   */
  public AccesscodemanagementImpl() {
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

    // Objects.requireNonNull(accessCode, "accessCode");
    // AccessCodeEntity accessCodeEntity = getBeanMapper().map(accessCode, AccessCodeEntity.class);
    //
    // AccessCodeSearchCriteriaTo criteria = new AccessCodeSearchCriteriaTo();
    // String code = generateCode(new Random(), 3);
    // criteria.setCode(code);
    //
    // while (!findAccessCodeEtos(criteria).getResult().isEmpty()) {
    // code = generateCode(new Random(), 3);
    // criteria.setCode(code);
    // }
    // accessCodeEntity.setCode(code);
    // accessCodeEntity.setDateAndTime(Timestamp.from(Instant.now().plus(1, ChronoUnit.DAYS)));
    //
    // // initialize, validate accessCodeEntity here if necessary
    // getAccessCodeDao().save(accessCodeEntity);
    // LOG.debug("AccessCode with id '{}' has been created.", accessCodeEntity.getId());
    //
    // return getBeanMapper().map(accessCodeEntity, AccessCodeEto.class);
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