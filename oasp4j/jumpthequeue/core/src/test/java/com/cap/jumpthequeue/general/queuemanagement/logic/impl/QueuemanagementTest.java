package com.cap.jumpthequeue.general.queuemanagement.logic.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.jumpthequeue.SpringBootApp;
import com.cap.jumpthequeue.queuemanagement.logic.api.Queuemanagement;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueEto;
import com.cap.jumpthequeue.queuemanagement.logic.api.to.QueueSearchCriteriaTo;

import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * @author machamou
 *
 */
@SpringBootTest(classes = SpringBootApp.class)
public class QueuemanagementTest extends ComponentTest {

  @Autowired
  private Queuemanagement queuemanagement;

  QueueEto queue = new QueueEto();

  QueueSearchCriteriaTo criteria = new QueueSearchCriteriaTo();

  @Override
  public void doSetUp() {

    this.queue.setDescriptionText("Test");
    this.queue.setMinWait(10);

  }

  @Test
  public void saveQueueTest() {

    QueueEto result = this.queuemanagement.saveQueue(this.queue);

    assertThat(result).isNotNull();
    assertThat(result.getMinWait() == 10);

  }

  @Test
  public void findQueueEtosTest() {

    PaginatedListTo<QueueEto> result = this.queuemanagement.findQueueEtos(this.criteria);
    assertThat(result).isNotNull();
  }

  @Test
  public void findQueueTest() {

    QueueEto result = this.queuemanagement.findQueue((long) 2);
    assertThat(result).isNotNull();
    assertThat(result.getId() == 2);
  }

  @Test
  public void updateQueueTest() {

    this.queue.setId((long) 2);
    QueueEto newqueue = new QueueEto();
    newqueue.setDescriptionText("Testmodif");
    QueueEto updatedQueue = this.queuemanagement.updateQueue(2, newqueue);

    assertThat(updatedQueue).isNotNull();
    assertThat(updatedQueue.getId() == 2);
    assertThat(updatedQueue.getDescriptionText().equals("Testmodif"));
  }

  // Can I made this? Need AccessCode

  /*
   * @Test public void attendQueueTest() {
   *
   * AccessCodeCto code = new AccessCodeCto(); code = this.queuemanagement.attendQueue(2); assertThat(code).isNotNull();
   * }
   */
}
