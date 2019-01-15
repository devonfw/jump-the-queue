package com.devonfw.application.jtqj.accesscodemanagement.logic.impl.usecase;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.application.jtqj.accesscodemanagement.dataaccess.api.AccessCodeEntity;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeCto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeEto;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase.UcFindAccessCode;
import com.devonfw.application.jtqj.accesscodemanagement.logic.api.usecase.UcManageAccessCode;
import com.devonfw.application.jtqj.accesscodemanagement.logic.base.usecase.AbstractAccessCodeUc;
import com.devonfw.application.jtqj.queuemanagement.dataaccess.api.QueueEntity;
import com.devonfw.application.jtqj.queuemanagement.logic.api.Queuemanagement;
import com.devonfw.application.jtqj.queuemanagement.logic.api.to.QueueEto;
import com.devonfw.application.jtqj.queuemanagement.logic.impl.usecase.UcManageQueueImpl;

@Named
@Validated
@Transactional
public class UcManageAccessCodeImpl extends AbstractAccessCodeUc implements UcManageAccessCode {

	@Inject
	private Queuemanagement queuemanagement;

	@Inject
	private UcFindAccessCode ucFindAccessCode;

	/** Logger instance. */
	private static final Logger LOG = LoggerFactory.getLogger(UcManageQueueImpl.class);

	@Override
	public Boolean deleteAccessCode(long accessCodeId) {

		// We get the queue, remove one customer and update it
		AccessCodeEntity accessCodeEntity = getAccessCodeRepository().find(accessCodeId);

		QueueEto queueEto = getBeanMapper().map(accessCodeEntity.getQueue(),QueueEto.class);
		int customerRemove = queueEto.getCustomers() - 1;
		queueEto.setCustomers(customerRemove);
		getQueuemanagement().saveQueue(queueEto);

		LOG.debug("The queue with id '{}' has decreased its customers to: {}.", queueEto.getId(),
				queueEto.getCustomers());

		// we delete the accesscode
		getAccessCodeRepository().delete(accessCodeEntity);
		LOG.debug("The accesscode with id '{}' has been deleted.", accessCodeId);

		return true;
	}

	@Override
	public AccessCodeEto saveAccessCode(AccessCodeEto accessCodeEto) {
		// We make sure the object is not null
		Objects.requireNonNull(accessCodeEto, "UcManageAccessImpl accessCode null");

		AccessCodeEntity accessCodeEntity = getBeanMapper().map(accessCodeEto, AccessCodeEntity.class);

		long queueEntityId = accessCodeEntity.getQueueId();

		AccessCodeSearchCriteriaTo accessCodeSearchCriteriaTo = new AccessCodeSearchCriteriaTo();
		accessCodeSearchCriteriaTo.setQueueId(queueEntityId);
		Pageable pageable = PageRequest.of(0, 1000);
		accessCodeSearchCriteriaTo.setPageable(pageable);

		// we get the list of ctos that are in the same queue than our eto
		List<AccessCodeCto> accessCodeCtosInQueue = getUcFindAccessCode().findAccessCodeCtos(accessCodeSearchCriteriaTo)
				.getContent();

		// if theres no ctos we set the ticket to the first code
		// else we get the digit of the last ticket in the list and generate a new code
		// for the ticket
		if (accessCodeCtosInQueue.isEmpty()) {
			accessCodeEntity.setTicketNumber("Q000");
		} else {
			AccessCodeEto lastAccessCode = accessCodeCtosInQueue.get(accessCodeCtosInQueue.size() - 1).getAccessCode();
			int lastTicketDigit = Integer.parseInt(lastAccessCode.getTicketNumber().substring(1));
			accessCodeEntity.setTicketNumber(generateTicketCode(lastTicketDigit));
		}
		// we set the creation time, startTime and endTime
		accessCodeEntity.setCreationTime(Timestamp.from(Instant.now()));
		accessCodeEntity.setStartTime(null);
		accessCodeEntity.setEndTime(null);
		// save the AccessCode
		AccessCodeEntity accessCodeEntitySaved = getAccessCodeRepository().save(accessCodeEntity);
		LOG.debug("The accesscode with id '{}' has been saved.", accessCodeEntitySaved.getId());
		QueueEntity queueEntity = getBeanMapper().map(getQueuemanagement().findQueue(queueEntityId), QueueEntity.class);

		// we add one customer to the queue and update it
		int customerAdd = queueEntity.getCustomers() + 1;
		queueEntity.setCustomers(customerAdd);
		QueueEto queueEtoSaved = getQueuemanagement().saveQueue(getBeanMapper().map(queueEntity, QueueEto.class));

		LOG.debug("The queue with id '{}' has increased its customers to: {}.", queueEtoSaved.getId(),
				queueEtoSaved.getCustomers());

		return getBeanMapper().map(accessCodeEntity, AccessCodeEto.class);
	}

	/**
	 * Generates a new ticked code using the ticket digit of the last codeaccess
	 * created
	 *
	 * @param lastTicketDigit the int of the last codeaccess created
	 * @return the String with the new ticket code (example: "Q005");
	 */
	public String generateTicketCode(int lastTicketDigit) {
		int newTicketDigit = lastTicketDigit + 1;
		String newTicketCode = "";
		if (newTicketDigit == 1000) {
			newTicketCode = "Q000";
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(newTicketDigit);
			while (stringBuilder.length() < 3) {
				stringBuilder.insert(0, "0");
			}
			stringBuilder.insert(0, "Q");
			newTicketCode = stringBuilder.toString();
		}
		return newTicketCode;
	}

	public Queuemanagement getQueuemanagement() {
		return this.queuemanagement;
	}
	public UcFindAccessCode getUcFindAccessCode(){
		return this.ucFindAccessCode;
	}

}
