// package com.cap.jumpthequeue.general.accesscodemanagement.logic.impl;
//
// import java.sql.Timestamp;
//
// import org.junit.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import com.cap.jumpthequeue.SpringBootApp;
// import com.cap.jumpthequeue.accesscodemanagement.logic.api.Accesscodemanagement;
// import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeCto;
// import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeEto;
// import com.cap.jumpthequeue.accesscodemanagement.logic.api.to.AccessCodeSearchCriteriaTo;
// import com.cap.jumpthequeue.usermanagement.logic.api.to.UserSearchCriteriaTo;
//
// import io.oasp.module.jpa.common.api.to.PaginatedListTo;
// import io.oasp.module.test.common.base.ComponentTest;
//
/// **
// * @author machamou
// *
// */
// @SpringBootTest(classes = SpringBootApp.class)
// public class AccessCodemanagementTest extends ComponentTest {
//
// @Autowired
// private Accesscodemanagement accessCodemanagement;
//
// AccessCodeEto accessCode = new AccessCodeEto();
//
// AccessCodeSearchCriteriaTo criteria = new AccessCodeSearchCriteriaTo();
//
// @Override
// public void doSetUp() {
//
// this.accessCode.setName("Test");
// this.accessCode.setEmail("Test@mail.com");
// this.accessCode.setPhone("1234");
// this.accessCode.setCode(111);
// this.accessCode.setIdentificator("aa00");
// this.accessCode.setCreationTime(Timestamp.valueOf("2017-12-12 20:00:00"));
// this.accessCode.setStartTime(Timestamp.valueOf("2017-12-12 20:01:00"));
// this.accessCode.setEndTime(Timestamp.valueOf("2017-12-12 20:02:00"));
// this.accessCode.setEstimatedTime(Timestamp.valueOf("2017-12-12 20:02:00"));
// this.accessCode.setPriority(false);
// }
//
// @Test
// public void findAccessCodeEtosTest() {
//
// PaginatedListTo<AccessCodeEto> result = this.accessCodemanagement.findAccessCodeEtos(this.criteria);
// assertThat(result).isNotNull();
// }
//
// @Test
// public void findAccessCodeTest() {
//
// AccessCodeCto result = this.accessCodemanagement.findAccessCode((long) 1);
// assertThat(result).isNotNull();
// assertThat(result.getAccessCode().getId() == 1);
// }
//
// @Test
// public void saveAccessCodeTest() {
//
// this.accessCode.setQueueId((long) 2);
// AccessCodeEto result = this.accessCodemanagement.saveAccessCode(this.accessCode);
// assertThat(result).isNotNull();
// assertThat(result.getName() == "Test");
// assertThat(result.getEmail() == "Test@mail.com");
// assertThat(result.getPhone() == "1234");
// assertThat(result.getCode() == 111);
// assertThat(result.getIdentificator() == "aa00");
// // assertThat(result.getCreationTime().compareTo(Timestamp.valueOf("2017-12-12 20:00")));
// // assertThat(result.getStartTime().compareTo(Timestamp.valueOf("2017-12-12 20:01")));
// // assertThat(result.getEndTime().compareTo(Timestamp.valueOf("2017-12-12 20:02")));
// // assertThat(result.getEstimatedTime().compareTo(Timestamp.valueOf("2017-12-12 20:02")));
// assertThat(result.getQueueId() == 2);
// assertThat(result.getPriority() == false);
// }
//
// @Test
// public void getVisitorAccessCodeTest() {
//
// // From mock data in User
// AccessCodeCto result = this.accessCodemanagement.getVisitorAccessCode("7d104727-ba80-4274-a6e6-89355a25941a");
//
// assertThat(result).isNotNull();
// }
//
// @Test
// public void findExistingAccessCodesByPostTest() {
//
// UserSearchCriteriaTo usercriteria = new UserSearchCriteriaTo();
// // From mock data in User
// usercriteria.setIdentificator("aa33");
// usercriteria.setEmail("peter@mail.com");
// AccessCodeCto result = this.accessCodemanagement.findExistingAccessCodesByPost(usercriteria);
// assertThat(result).isNotNull();
// assertThat(result.getAccessCode().getEmail().equals("peter@mail.com"));
// assertThat(result.getAccessCode().getIdentificator().equals("aa33"));
// }
//
// // TODO ADD more tests until completion
//
// }
