package com.accolite.opportunity.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.opportunity.exception.OpportunityNotFoundException;
import com.accolite.opportunity.exception.OpportunityServiceErrorException;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.mysql.dao.OpportunityDao;
//import com.accolite.opportunity.mysql.dao.UsersDao;

@Service
public class OpportunityService {

	@Autowired
	private OpportunityDao opportunityDao;
	

	
	
	// Retrieve all rows from table and populate list with objects
		public List<Opportunity> getAllOpportunities() {
			List<Opportunity> opportunities = new ArrayList<>();
			System.out.println("Inside opportunity Service");
		
			return (List<Opportunity>) opportunityDao.findAll();
		}
		
		// Retrieves one row from table based on given id
		public Optional<Opportunity> getOpportunity(Integer id) {
			return opportunityDao.findById(id);
		}
		
		// Inserts row into table 
		public boolean addOpportunity(Opportunity opportunity) {
			boolean isAdded = false;
			try {
			 if(opportunityDao.save(opportunity) == null)
			 {
				 throw new OpportunityServiceErrorException();
				 
			 }
			isAdded = true;
			}catch(OpportunityServiceErrorException e) {
				
			}
			return isAdded;
		}
		
	// Updates row in table
		public boolean updateOpportunity( Opportunity opportunity) {
			boolean isUpdated = false;
			Optional<Opportunity> opd = opportunityDao.findById(opportunity.getOpportunityid());
			System.out.println(opd);
			try {
				if(opd.isPresent()) {
				if(opportunityDao.save(opportunity) == null) {
					throw new OpportunityNotFoundException();
				}
				
				isUpdated = true;
				}
				else {
					throw new OpportunityNotFoundException();
				}
			}catch(OpportunityNotFoundException e) {
				throw new OpportunityNotFoundException();
					
				
			}
			return isUpdated;
			
		}
		
	// Removes row from table
		public boolean deleteOpportunity(Integer id) {
			boolean isDeleted = false;
			try {
			opportunityDao.deleteById(id);
			isDeleted = true;
			}
			catch(OpportunityServiceErrorException e) {
				
				throw new OpportunityServiceErrorException();
			}
			return isDeleted;
		}
		
		
}


