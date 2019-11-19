package org.egov.waterConnection.validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.egov.tracer.model.CustomException;
import org.egov.waterConnection.model.SewerageConnection;
import org.egov.waterConnection.model.SewerageConnectionRequest;
import org.egov.waterConnection.repository.SewarageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SewerageConnectionValidator {
	
	@Autowired
	SewarageDao sewarageDao;

	/**
	 * 
	 * @param sewarageConnectionRequest SewarageConnectionRequest is request for create or update sewarage connection
	 * @param isUpdate True for update and false for create
	 */
	public void validateSewerageConnection(SewerageConnectionRequest sewerageConnectionRequest, boolean isUpdate) {
		SewerageConnection sewerageConnection = sewerageConnectionRequest.getSewerageConnection();
		Map<String, String> errorMap = new HashMap<>();
		if (isUpdate && (sewerageConnection.getId() == null || sewerageConnection.getId().isEmpty())) {
			errorMap.put("INVALID SEWARAGE CONNECTION", "SewarageConnection cannot be updated without connection id");
		}
		if (isUpdate && sewerageConnection.getId() != null && !sewerageConnection.getId().isEmpty()) {
			int n = sewarageDao.isSewerageConnectionExist(Arrays.asList(sewerageConnection.getId()));
			if (n == 0) {
				errorMap.put("INVALID SEWARAGE CONNECTION", "Sewarage Id not present");
			}
		}
		
      if (!errorMap.isEmpty())
			throw new CustomException(errorMap);
	}


}