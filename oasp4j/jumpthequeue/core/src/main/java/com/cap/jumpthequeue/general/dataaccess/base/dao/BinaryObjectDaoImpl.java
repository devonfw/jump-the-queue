package com.cap.jumpthequeue.general.dataaccess.base.dao;

import javax.inject.Named;

import com.cap.jumpthequeue.general.dataaccess.api.BinaryObjectEntity;
import com.cap.jumpthequeue.general.dataaccess.api.dao.BinaryObjectDao;

/**
 * Implementation of {@link BinaryObjectDao}.
 *
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}
