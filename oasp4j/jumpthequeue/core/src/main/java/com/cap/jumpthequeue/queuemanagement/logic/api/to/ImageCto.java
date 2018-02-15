package com.cap.jumpthequeue.queuemanagement.logic.api.to;

import com.cap.jumpthequeue.general.common.api.to.AbstractCto;

/**
 * Composite transport object of Image
 */
public class ImageCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private ImageEto image;

  private QueueEto queue;

  public ImageEto getImage() {

    return image;
  }

  public void setImage(ImageEto image) {

    this.image = image;
  }

  public QueueEto getQueue() {

    return queue;
  }

  public void setQueue(QueueEto queue) {

    this.queue = queue;
  }

}
