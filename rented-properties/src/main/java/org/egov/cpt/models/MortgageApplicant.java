package org.egov.cpt.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MortgageApplicant {

	@JsonProperty("id")
	private String id;

	@JsonProperty("mortgageId")
	private String mortgageId;

	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("guardian")
	private String guardian;

	@JsonProperty("relationship")
	private String relationship;

	@JsonProperty("adhaarNumber")
	private String adhaarNumber;
	
	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;


}
