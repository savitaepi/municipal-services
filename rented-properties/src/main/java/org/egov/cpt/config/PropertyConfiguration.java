package org.egov.cpt.config;

import java.math.BigDecimal;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.egov.tracer.config.TracerConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Import({ TracerConfiguration.class })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class PropertyConfiguration {

	@Value("${app.timezone}")
	private String timeZone;

	@PostConstruct
	public void initialize() {
		TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
	}

	@Bean
	@Autowired
	public MappingJackson2HttpMessageConverter jacksonConverter(ObjectMapper objectMapper) {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	// PERSISTER
	@Value("${persister.save.property.topic}")
	private String savePropertyTopic;

	@Value("${persister.update.property.topic}")
	private String updatePropertyTopic;

	@Value("${persister.save.duplicateCopy.topic}")
	private String saveDuplicateCopyTopic;

	@Value("${persister.update.duplicateCopy.topic}")
	private String UpdateDuplicateCopyTopic;
	
	@Value("${persister.save.propertyImages.topic}")
	private String savePropertyImagesTopic;
	
	@Value("${persister.update.propertyImages.topic}")
	private String UpdatePropertyImagesTopic;

	@Value("${ownership.transfer.save.topic}")
	private String ownershipTransferSaveTopic;

	@Value("${ownership.transfer.update.topic}")
	private String ownershipTransferUpdateTopic;
	
	@Value("${persister.save.mortgage.topic}")
	private String saveMortgageTopic;
	
	@Value("${persister.update.mortgage.topic}")
	private String updateMortgageTopic;

	@Value("${persister.cancel.property.topic}")
	private String cancelPropertyTopic;
	
	@Value("${persister.save.notice.topic}")
	private String saveNoticeTopic;
	
	@Value("${persister.update.notice.topic}")
	private String updateNoticeTopic;
	

	@Value("${persister.cancel.property.assessment.topic}")
	private String cancelPropertyAssessmentTopic;

	// USER
	@Value("${egov.user.host}")
	private String userHost;

	@Value("${egov.user.search.path}")
	private String userSearchEndpoint;

	// IDGEN
//	@Value("${egov.idgen.ack.name}")
//	private String acknowldgementIdGenName;
//
//	@Value("${egov.idgen.ack.format}")
//	private String acknowldgementIdGenFormat;
//
//	@Value("${egov.idgen.assm.name}")
//	private String assessmentIdGenName;
//
//	@Value("${egov.idgen.assm.format}")
//	private String assessmentIdGenFormat;
//
//	@Value("${egov.idgen.ptid.name}")
//	private String propertyIdGenName;
//
//	@Value("${egov.idgen.ptid.format}")
//	private String propertyIdGenFormat;

	// NOTIFICATION TOPICS
	@Value("${kafka.topics.notification.sms}")
	private String smsNotifTopic;

	@Value("${kafka.topics.notification.fullpayment}")
	private String receiptTopic;

	@Value("${kafka.topics.notification.pg.save.txns}")
	private String pgTopic;

	@Value("${egov.localization.statelevel}")
	private Boolean isStateLevel;

	@Value("${notification.sms.enabled}")
	private Boolean isSMSNotificationEnabled;
	
	@Value("${notification.email.enabled}")
	private Boolean isEMAILNotificationEnabled;
	
	@Value("${kafka.topics.notification.email}")
	private String emailNotifTopic;

	// Property Search Params
	@Value("${citizen.allowed.search.params}")
	private String citizenSearchParams;

	@Value("${employee.allowed.search.params}")
	private String employeeSearchParams;

	@Value("${notification.url}")
	private String notificationURL;

	@Value("${pt.search.pagination.default.limit}")
	private Long defaultLimit;

	@Value("${pt.search.pagination.default.offset}")
	private Long defaultOffset;

	@Value("${pt.search.pagination.max.search.limit}")
	private Long maxSearchLimit;

	// Localization
	@Value("${egov.localization.host}")
	private String localizationHost;

	@Value("${egov.localization.context.path}")
	private String localizationContextPath;

	@Value("${egov.localization.search.endpoint}")
	private String localizationSearchEndpoint;

	// USER EVENTS
	@Value("${egov.ui.app.host}")
	private String uiAppHost;

	@Value("${egov.usr.events.create.topic}")
	private String saveUserEventsTopic;

	@Value("${egov.usr.events.pay.link}")
	private String payLink;

	@Value("${egov.usr.events.pay.code}")
	private String payCode;

	@Value("${egov.user.event.notification.enabled}")
	private Boolean isUserEventsNotificationEnabled;

	// Assessments V2
	@Value("${egov.pt.assessment.create.topic}")
	private String createAssessmentTopic;

	@Value("${egov.pt.assessment.update.topic}")
	private String updateAssessmentTopic;

	// Workflow

	@Value("${property.workflow.name}")
	private String propertyRegistryWf;

	@Value("${pt.business.codes}")
	private List<String> businessServiceList;

	@Value("${workflow.context.path}")
	private String wfHost;

	@Value("${workflow.transition.path}")
	private String wfTransitionPath;

	@Value("${workflow.businessservice.search.path}")
	private String wfBusinessServiceSearchPath;

	@Value("${is.workflow.enabled}")
	private Boolean isWorkflowEnabled;

	@Value("${workflow.status.active}")
	private String wfStatusActive;

	@Value("${create.csp.workflow.name}")
	private String cSPBusinessServiceValue;

	@Value("${ownershipTransfer.worlflow.name}")
	private String ownershipTransferBusinessServiceValue;

	@Value("${duplicateCopy.workflow.name}")
	private String duplicateCopyBusinessServiceValue;
	
	@Value("${mortgage.workflow.name}")
	private String mortgageBusinessServiceValue;

	// ##### mdms

	@Value("${egov.mdms.host}")
	private String mdmsHost;

	@Value("${egov.mdms.search.endpoint}")
	private String mdmsEndpoint;

	// Registry

	@Value("${property.min.landarea}")
	private Double minumumLandArea;

	@Value("${property.unit.landarea}")
	private String landAreaUnit;

	@Value("${property.module.name}")
	private String propertyModuleName;

//	ID Generation

	@Value("${egov.idgen.host}")
	private String idGenHost;

	@Value("${egov.idgen.path}")
	private String idGenPath;

	@Value("${egov.idgen.rp.applicationNum.name}")
	private String applicationNumberIdgenNameRP;

	@Value("${egov.idgen.rp.applicationNum.format}")
	private String applicationNumberIdgenFormatRP;
	
	@Value("${egov.idgen.rp.allotmentNum.name}")
	private String allotmentNumberIdgenNameRP;

	@Value("${egov.idgen.rp.allotmentNum.format}")
	private String allotmentNumberIdgenFormatRP;

	@Value("${egov.idgen.dc.applicationNum.name}")
	private String applicationNumberIdgenNameDC;

	@Value("${egov.idgen.dc.applicationNum.format}")
	private String applicationNumberIdgenFormatDC;
	
	@Value("${egov.idgen.mg.applicationNum.name}")
	private String applicationNumberIdgenNameMG;

	@Value("${egov.idgen.mg.applicationNum.format}")
	private String applicationNumberIdgenFormatMG;
	
	@Value("${egov.idgen.pi.applicationNum.name}")
	private String applicationNumberIdgenNamePI;
	
	@Value("${egov.idgen.pi.applicationNum.format}")
	private String applicationNumberIdgenFormatPI;
	
	@Value("${egov.idgen.ng.memoNum.name}")
	private String memoNumberIdgenNameNG;

	@Value("${egov.idgen.ng.memoNum.format}")
	private String memoNumbeIdgenFormatNG;
	
//	BilllingService generating demand 

	@Value("${egov.billingservice.host}")
	private String billingHost;

	@Value("${egov.demand.create.endpoint}")
	private String demandCreateEndpoint;

	@Value("${egov.demand.minimum.payable.amount}")
	private BigDecimal minimumPayableAmount;

	@Value("${egov.demand.search.endpoint}")
	private String demandSearchEndpoint;

	@Value("${egov.demand.update.endpoint}")
	private String demandUpdateEndpoint;
	
	@Value("${egov.bill.gen.endpoint}")
	private String billGenearateEndpoint;
	
	@Value("${egov.collectionservice.host}")
	private String collectionPaymentHost;
	
	
	@Value("${egov.collectionservice.payment.create.path}")
	private String collectionPaymentEndPoint;
	
	
	

}