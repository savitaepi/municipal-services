package org.egov.cpt.models;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * A Object holds the basic data for a Property
 */
@ApiModel(description = "A Object holds the basic data for a Property")
@Validated
@javax.annotation.Generated(value = "org.egov.codegen.SpringBootCodegen", date = "2018-09-18T17:06:11.263+05:30")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Address {

	@JsonProperty("id")
	private String id;

	@JsonProperty("propertyId")
	private String propertyId;

	@JsonProperty("transitNumber")
	private String transitNumber;

	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("colony")
	private String colony;

	@JsonProperty("area")
	private String area;

	@JsonProperty("district")
	private String district;

	@JsonProperty("state")
	private String state;

	@JsonProperty("country")
	private String country;

	@JsonProperty("pincode")
	private String pincode;

	@JsonProperty("landmark")
	private String landmark;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;
}
