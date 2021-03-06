package org.egov.bookings.config;

import java.math.BigDecimal;
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
public class BookingsConfiguration {

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

	// User Config
	@Value("${egov.user.host}")
	private String userHost;

	@Value("${egov.user.search.path}")
	private String userSearchEndpoint;

	// Idgen Config
	@Value("${egov.idgen.host}")
	private String idGenHost;

	@Value("${egov.idgen.path}")
	private String idGenPath;

	@Value("${egov.idgen.bk.applicationNum.name}")
	private String applicationNumberIdgenName;

	@Value("${egov.idgen.bk.applicationNum.format}")
	private String applicationNumberIdgenFormat;

	@Value("${egov.demand.update.endpoint}")
	private String demandUpdateEndPoint;

	@Value("${kafka.topics.save.booking.sms.notification.service}")
	private String saveBookingSMSTopic;

	@Value("${kafka.topics.update.sms.notification.service}")
	private String updateBookingSMSTopic;

	@Value("${kafka.topics.save.nlujm.sms.notification.service}")
	private String saveNLUJMBookingSMSTopic;

	@Value("${kafka.topics.update.nlujm.sms.notification.service}")
	private String updateNLUJMBookingSMSTopic;

	@Value("${kafka.topics.save.approver.service}")
	private String saveApproverTopic;

	@Value("${kafka.topics.update.approver.service}")
	private String updateApproverTopic;

	@Value("${kafka.topics.notification.sms}")
	private String smsNotifTopic;

	@Value("${notification.sms.enabled}")
	private Boolean isSMSEnabled;

	@Value("${notification.sms.enabled.forBK}")
	private Boolean isBKSMSEnabled;

	@Value("${kafka.topics.notification.email}")
	private String emailNotifTopic;

	@Value("${notification.email.enabled.forBK}")
	private Boolean isBKEMAILEnabled;

	@Value("${egov.localization.host}")
	private String localizationHost;

	@Value("${egov.localization.context.path}")
	private String localizationContextPath;

	@Value("${egov.localization.search.endpoint}")
	private String localizationSearchEndpoint;

	@Value("${egov.localization.statelevel}")
	private Boolean isLocalizationStateLevel;

	@Value("${egov.mdms.host}")
	private String mdmsHost;

	@Value("${egov.mdms.search.endpoint}")
	private String mdmsEndPoint;

	@Value("${workflow.context.path}")
	private String wfHost;

	@Value("${workflow.transition.path}")
	private String wfTransitionPath;

	@Value("${workflow.businessservice.search.path}")
	private String wfBusinessServiceSearchPath;

	@Value("${is.external.workflow.enabled}")
	private Boolean isExternalWorkFlowEnabled;

	@Value("${workflow.process.search.path}")
	private String workflowProcessInstancePath;

	// USER EVENTS
	@Value("${egov.ui.app.host}")
	private String uiAppHost;

	@Value("${egov.usr.events.create.topic}")
	private String saveUserEventsTopic;

	@Value("${egov.usr.events.pay.code}")
	private String payCode;

	@Value("${egov.usr.events.pay.triggers}")
	private String payTriggers;

	@Value("${egov.usr.events.ctl.pay.link}")
	private String ctlPayLink;

	@Value("${egov.demand.create.endpoint}")
	private String demandCreateEndpoint;

	@Value("${egov.billingservice.host}")
	private String billingHost;

	@Value("${egov.demand.minimum.payable.amount}")
	private BigDecimal minimumPayableAmount;

	@Value("${egov.demand.search.endpoint}")
	private String demandSearchEndpoint;

	@Value("${egov.lock.jurisdiction.payment}")
	private boolean jurisdictionLock;

	@Value("${egov.lock.commercial.payment}")
	private boolean commercialLock;

	@Value("${egov.lock.park.and.commercial.payment}")
	private boolean parkAndCommercialLock;

	@Value("${kafka.topics.save.service}")
	private String saveBookingTopic;

	@Value("${kafka.topics.save.nlujm.service}")
	private String saveNewLocationTopic;

	@Value("${kafka.topics.update.service}")
	private String updateBookingTopic;

	@Value("${kafka.topics.update.nlujm.service}")
	private String updateNewLocationTopic;

}
