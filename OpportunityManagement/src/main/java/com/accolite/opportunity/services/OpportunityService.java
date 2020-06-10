package com.accolite.opportunity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.accolite.logging.Log4jLogger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.accolite.opportunity.model.Opportunity;

import com.accolite.opportunity.mysql.dao.OpportunityDao;
//import com.accolite.opportunity.mysql.dao.UsersDao;

@Service
public class OpportunityService {
//	private static final Logger LOG = Log4jLogger.log;
//	
	@Autowired
	private OpportunityDao opportunityDao;
	
//	@Autowired 
//	private UsersDao dao1;
	
	
	// Retrieve all rows from table and populate list with objects
		public List<Opportunity> getAllOpportunities() {
			List<Opportunity> opportunities = new ArrayList<>();
		opportunityDao.findAll().forEach(opportunities::add);
			return opportunities;
		}
		
		// Retrieves one row from table based on given id
		public Optional<Opportunity> getOpportunity(Integer id) {
			return opportunityDao.findById(id);
		}
		
		// Inserts row into table 
		public void addOpportunity(Opportunity opportunity) {
			opportunityDao.save(opportunity);
		}
		
	// Updates row in table
		public void updateOpportunity( Opportunity opportunity) {
			opportunityDao.save(opportunity);
		}
		
	// Removes row from table
		public void deleteOpportunity(Integer id) {
			opportunityDao.deleteById(id);
		}
		
		
}


