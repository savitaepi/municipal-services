package org.egov.cpt.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.egov.cpt.models.AuditDetails;
import org.egov.cpt.models.Document;
import org.egov.cpt.models.NoticeGeneration;
import org.egov.cpt.models.Property;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

@Component
public class NoticeRowMapper implements ResultSetExtractor<List<NoticeGeneration>> {

	@Override
	public List<NoticeGeneration> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, NoticeGeneration> applicationMap = new HashMap<>();
		while (rs.next()) {
			String noticeId = rs.getString("ngid");
			NoticeGeneration currentapplication = applicationMap.get(noticeId);

			if (null == currentapplication) {
				AuditDetails auditdetails = AuditDetails.builder().createdBy(rs.getString("created_by"))
						.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("modified_by"))
						.lastModifiedTime(rs.getLong("modified_time")).build();
				
				Property property = Property.builder().id(rs.getString("pid"))
						.transitNumber(rs.getString("transit_number")).colony(rs.getString("colony")).build();
				
				currentapplication = NoticeGeneration.builder().id(noticeId).property(property)
						.tenantId(rs.getString("tenantid"))
						.memoNumber(rs.getString("memoNumber"))
						.memoDate(rs.getLong("memoDate"))
						.noticeType(rs.getString("noticeType"))
						.guardian(rs.getString("guardian"))
						.relationship(rs.getString("relationship"))
						.violations(rs.getString("violations"))
						.description(rs.getString("description"))
						.demandNoticeFrom(rs.getLong("demandNoticeFrom"))
						.demandNoticeTo(rs.getLong("demandNoticeTo"))
						.recoveryType(rs.getString("recoveryType"))
						.amount(rs.getDouble("amount"))
						.auditDetails(auditdetails).build();
				applicationMap.put(noticeId, currentapplication);

			}
			addChildrenToProperty(rs, currentapplication);
		}
		return new ArrayList<>(applicationMap.values());

	}

	private void addChildrenToProperty(ResultSet rs, NoticeGeneration currentapplication) throws SQLException {

		AuditDetails auditDetails = AuditDetails.builder().createdBy(rs.getString("created_by"))
				.createdTime(rs.getLong("created_time")).lastModifiedBy(rs.getString("modified_by"))
				.lastModifiedTime(rs.getLong("created_time")).build();
		
		if (rs.getString("docId") != null && rs.getBoolean("doc_active")) {
			Document applicationDocument = Document.builder()
					.documentType(rs.getString("doctype"))
					.fileStoreId(rs.getString("doc_filestoreid"))
					.id(rs.getString("docId"))
				    .propertyId(rs.getString("doc_propertyid"))
					.tenantId(rs.getString("doctenantid"))
					.active(rs.getBoolean("doc_active"))
					.referenceId(rs.getString("doc_referenceid"))
					.auditDetails(auditDetails)
					.build();
			currentapplication.addApplicationDocumentsItem(applicationDocument);
		}

	}

}