package com.cap.jumpthequeue.ownermanagement.logic.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;
import com.cap.jumpthequeue.ownermanagement.dataaccess.api.OwnerEntity;
import com.cap.jumpthequeue.ownermanagement.dataaccess.api.dao.OwnerDao;
import com.cap.jumpthequeue.ownermanagement.logic.api.Ownermanagement;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerEto;
import com.cap.jumpthequeue.ownermanagement.logic.api.to.OwnerSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of ownermanagement
 */
@Named
@Transactional
public class OwnermanagementImpl extends AbstractComponentFacade implements Ownermanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(OwnermanagementImpl.class);

  /** @see #getOwnerDao() */
  @Inject
  private OwnerDao ownerDao;

  /**
   * The constructor.
   */
  public OwnermanagementImpl() {
    super();
  }

  @Override
  public OwnerEto findOwner(Long id) {

    LOG.debug("Get Owner with id {} from database.", id);
    return getBeanMapper().map(getOwnerDao().findOne(id), OwnerEto.class);
  }

  @Override
  public PaginatedListTo<OwnerEto> findOwnerEtos(OwnerSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<OwnerEntity> owners = getOwnerDao().findOwners(criteria);
    return mapPaginatedEntityList(owners, OwnerEto.class);
  }

  @Override
  public boolean deleteOwner(Long ownerId) {

    OwnerEntity owner = getOwnerDao().find(ownerId);
    getOwnerDao().delete(owner);
    LOG.debug("The owner with id '{}' has been deleted.", ownerId);
    return true;
  }

  @Override
  public OwnerEto saveOwner(OwnerEto owner) {

    Objects.requireNonNull(owner, "owner");
    OwnerEntity ownerEntity = getBeanMapper().map(owner, OwnerEntity.class);

    // initialize, validate ownerEntity here if necessary
    OwnerEntity resultEntity = getOwnerDao().save(ownerEntity);
    LOG.debug("Owner with id '{}' has been created.", resultEntity.getId());

    return getBeanMapper().map(resultEntity, OwnerEto.class);
  }

  /**
   * Returns the field 'ownerDao'.
   * 
   * @return the {@link OwnerDao} instance.
   */
  public OwnerDao getOwnerDao() {

    return this.ownerDao;
  }

}