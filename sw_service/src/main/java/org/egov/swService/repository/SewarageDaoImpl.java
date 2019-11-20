package org.egov.swService.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.egov.common.contract.request.RequestInfo;
import org.egov.swService.model.SewerageConnection;
import org.egov.swService.model.SewerageConnectionRequest;
import org.egov.swService.model.SearchCriteria;
import org.egov.swService.producer.SewarageConnectionProducer;
import org.egov.swService.repository.builder.WsQueryBuilder;
import org.egov.swService.repository.rowmapper.SewerageRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SewarageDaoImpl implements SewarageDao {

	@Autowired
	SewarageConnectionProducer sewarageConnectionProducer;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	WsQueryBuilder wsQueryBuilder;

	

	@Autowired
	SewerageRowMapper sewarageRowMapper;

	@Value("${egov.sewarageservice.createSewarageConnection}")
	private String createSewarageConnection;

	@Value("${egov.sewarageservice.updateSewarageConnection}")
	private String updateSewarageConnection;

	@Override
	public void saveSewerageConnection(SewerageConnectionRequest sewerageConnectionRequest) {
		sewarageConnectionProducer.push(createSewarageConnection, sewerageConnectionRequest);
	}

	@Override
	public List<SewerageConnection> getSewerageConnectionList(SearchCriteria criteria,
			RequestInfo requestInfo) {
		List<SewerageConnection> sewarageConnectionList = new ArrayList<>();
		List<Object> preparedStatement = new ArrayList<>();
		
		String query = wsQueryBuilder.getSearchQueryString(criteria, preparedStatement, requestInfo, false);
		log.info("Sewarage Search Query: " +query);
		sewarageConnectionList = jdbcTemplate.query(query, preparedStatement.toArray(), sewarageRowMapper);
		return sewarageConnectionList;
	}

	@Override
	public int isSewerageConnectionExist(List<String> ids) {
		int n = 0;
		Set<String> connectionIds = new HashSet<>(ids);
		List<Object> preparedStatement = new ArrayList<>();
		String query = wsQueryBuilder.getNoOfWaterConnectionQuery(connectionIds, preparedStatement);
		n = jdbcTemplate.queryForObject(query, preparedStatement.toArray(), Integer.class);
		return n;
	}

	@Override
	public void updatSewerageConnection(SewerageConnectionRequest sewerageConnectionRequest) {
		sewarageConnectionProducer.push(updateSewarageConnection, sewerageConnectionRequest);
	}

}
