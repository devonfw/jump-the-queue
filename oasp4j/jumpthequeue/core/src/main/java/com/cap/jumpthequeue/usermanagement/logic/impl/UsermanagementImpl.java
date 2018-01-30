package com.cap.jumpthequeue.usermanagement.logic.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.cap.jumpthequeue.accesscodemanagement.common.api.AccessCode;
import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.cap.jumpthequeue.accesscodemanagement.dataaccess.api.dao.AccessCodeDao;
import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.cap.jumpthequeue.general.logic.base.AbstractComponentFacade;
import com.cap.jumpthequeue.usermanagement.dataaccess.api.UserEntity;
import com.cap.jumpthequeue.usermanagement.dataaccess.api.dao.UserDao;
import com.cap.jumpthequeue.usermanagement.logic.api.Usermanagement;
import com.cap.jumpthequeue.usermanagement.logic.api.to.UserEto;
import com.cap.jumpthequeue.usermanagement.logic.api.to.UserSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of usermanagement
 */
@Named
@Transactional
public class UsermanagementImpl extends AbstractComponentFacade implements Usermanagement {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UsermanagementImpl.class);

  /** @see #getUserDao() */
  @Inject
  private UserDao userDao;

  /**
   * @see #getAccessCodeDaoDao()
   */
  @Inject
  private AccessCodeDao accescodeDao;

  /**
   * The constructor.
   */
  public UsermanagementImpl() {
    super();
  }

  @Override
  public UserEto findUser(Long id) {

    LOG.debug("Get User with id {} from database.", id);
    return getBeanMapper().map(getUserDao().findOne(id), UserEto.class);
  }

  @Override
  public PaginatedListTo<UserEto> findUserEtos(UserSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<UserEntity> users = getUserDao().findUsers(criteria);
    return mapPaginatedEntityList(users, UserEto.class);
  }

  @Override
  public boolean deleteUser(Long userId) {

    UserEntity user = getUserDao().find(userId);
    getUserDao().delete(user);
    LOG.debug("The user with id '{}' has been deleted.", userId);
    return true;
  }

  @Override
  public UserEto saveUser(UserEto user) {

    Objects.requireNonNull(user, "user");
    UserEntity userEntity = getBeanMapper().map(user, UserEntity.class);

    // Search for existing email in User and AccessCode Entity
    UserSearchCriteriaTo usercriteria = new UserSearchCriteriaTo();
    usercriteria.setEmail(user.getEmail());
    PaginatedListTo<UserEntity> users = getUserDao().findUsers(usercriteria);

    AccessCodeSearchCriteriaTo accescodecriteria = new AccessCodeSearchCriteriaTo();
    accescodecriteria.setEmail(user.getEmail());
    accescodecriteria.setCreationTime(null);
    PaginatedListTo<AccessCodeEntity> codes = getAccessCodeDao().findAccessCodes(accescodecriteria);

    if (users.getResult().size() != 0 || codes.getResult().size() != 0) {
      throw new BadRequestException();
    }

    // Generate UUID TOKEN - random -- Must have add expiration time ?
    UUID uuid = UUID.randomUUID();
    String randomUUIDString = uuid.toString();
    String token = randomUUIDString;

    // Generate identificator
    // TODO- ExpandFor more User
    String leters = "ABCDEFGHI";
    String numbers = "123456789";

    String identificator = RandomStringUtils.random(1, leters) + RandomStringUtils.random(1, numbers)
        + RandomStringUtils.random(1, leters) + RandomStringUtils.random(1, numbers);
    // randomAlphanumeric(4). ;

    // Asign token and identificator to current user
    userEntity.setToken(token);
    userEntity.setIdentificator(identificator);
    userEntity.setCreationTime(Timestamp.from(Instant.now()));

    // Save User to UserTable
    UserEntity resultEntity = getUserDao().save(userEntity);
    LOG.debug("User with id '{}' has been created.", resultEntity.getId());

    // return user created
    return getBeanMapper().map(resultEntity, UserEto.class);
  }

  /**
   * Returns the field 'userDao'.
   *
   * @return the {@link UserDao} instance.
   */
  public UserDao getUserDao() {

    return this.userDao;
  }

  /**
   * Returns the field 'accessCodeDao'.
   *
   * @return the {@link AccessCode} instance.
   */
  private AccessCodeDao getAccessCodeDao() {

    return this.accescodeDao;
  }

}