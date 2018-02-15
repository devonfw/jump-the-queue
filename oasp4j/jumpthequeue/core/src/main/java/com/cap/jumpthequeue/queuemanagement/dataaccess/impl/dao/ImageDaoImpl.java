package com.cap.jumpthequeue.queuemanagement.dataaccess.impl.dao;

import javax.inject.Named;

import org.apache.http.entity.ContentType;

import com.cap.jumpthequeue.general.dataaccess.base.dao.ApplicationDaoImpl;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.ImageEntity;
import com.cap.jumpthequeue.queuemanagement.dataaccess.api.dao.ImageDao;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.ImageSearchCriteriaTo;
import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link ImageDao}.
 */
@Named
public class ImageDaoImpl extends ApplicationDaoImpl<ImageEntity> implements ImageDao {

  /**
   * The constructor.
   */
  public ImageDaoImpl() {

    super();
  }

  @Override
  public Class<ImageEntity> getEntityClass() {

    return ImageEntity.class;
  }

  @Override
  public PaginatedListTo<ImageEntity> findImages(ImageSearchCriteriaTo criteria) {

    ImageEntity image = Alias.alias(ImageEntity.class);
    EntityPathBase<ImageEntity> alias = Alias.$(image);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where(Alias.$(image.getName()).eq(name));
    }
    String content = criteria.getContent();
    if (content != null) {
      query.where(Alias.$(image.getContent()).eq(content));
    }
    ContentType contentType = criteria.getContentType();
    if (contentType != null) {
      query.where(Alias.$(image.getContentType()).eq(contentType));
    }
    String mimeType = criteria.getMimeType();
    if (mimeType != null) {
      query.where(Alias.$(image.getMimeType()).eq(mimeType));
    }
    Long queue = criteria.getQueueId();
    if (queue != null) {
      if (image.getQueue() != null) {
        query.where(Alias.$(image.getQueue().getId()).eq(queue));
      }
    }
    return findPaginated(criteria, query, alias);
  }

}