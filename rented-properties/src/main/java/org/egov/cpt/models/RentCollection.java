package org.egov.cpt.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode
public class RentCollection {
	/**
	 * Unique id of the collection
	 */
	@JsonProperty("id")
	private String id;

	/**
	 * The timestamp at which this collection was made. This is not same as
	 * createdAt.
	 */
	private long collectedAt;

	/**
	 * Demand Id of the demand that this fulfils.
	 */
	@ToString.Include
	@JsonProperty("demandId")
	private String demandId;

	/**
	 * Interest collected.
	 */
	@Builder.Default
	@ToString.Include
	@JsonProperty("interestCollected")
	private Double interestCollected = 0D;

	/**
	 * Principal collected.
	 */
	@Builder.Default
	@ToString.Include
	@JsonProperty("principalCollected")
	private Double principalCollected = 0D;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;

}
