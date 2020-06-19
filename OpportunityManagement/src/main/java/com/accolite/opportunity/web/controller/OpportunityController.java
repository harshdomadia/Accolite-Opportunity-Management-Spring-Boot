package com.accolite.opportunity.web.controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.logging.Log4jLogger;
import com.accolite.opportunity.exception.OpportunityNotFoundException;
import com.accolite.opportunity.exception.OpportunityServiceErrorException;
import com.accolite.opportunity.interceptor.Interceptors;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.mysql.dao.OpportunityDao;
import com.accolite.opportunity.services.OpportunityService;




@CrossOrigin(origins = "${allowedorigin}", allowedHeaders = "*")
@RestController
public class OpportunityController {
	private static final Logger LOG = Log4jLogger.log;
	@Autowired 
	private OpportunityDao dao;
	
	@Autowired
	private Interceptors interceptor;
	
	@Autowired
	private OpportunityService opportunityService;
	
	@PostMapping("/api/create")
	public List<Opportunity> addData(@RequestBody Opportunity opportunity,@RequestHeader("emailid") String emailid, @RequestHeader("token") String token) {
		
		
		
		LOG.info("Inside Opportunity Add Class");
		LOG.info("verifying user");
		if(interceptor.verfiyUser(emailid, token)) {
		try {
		
			if(opportunityService.addOpportunity(opportunity)==false) {
				throw new OpportunityServiceErrorException();
			}
		}catch(Exception e) {
			LOG.warn("Exception Occured while Adding");
			LOG.error("Error in Adding Opportunityr:"+e.toString());
					}
		LOG.info("Opportunity Registered into DB");
		return opportunityService.getAllOpportunities();
		}
		else {
			LOG.warn("User not verified");
			return null;
			
		}
		
		
		
	}
	@GetMapping("/api/get")
	
	public List<Opportunity> getData(@RequestHeader("emailid") String emailid, @RequestHeader("token") String token){
	
		
		LOG.info("Inside Opportunity Get Class");
		LOG.info("verifying user");
	if(interceptor.verfiyUser(emailid, token))
		{
		List<Opportunity> allOpportunity=null;
		try {
			LOG.info("Trying to Find User in DB by retreiving all data");
			allOpportunity = opportunityService.getAllOpportunities();
			System.out.println(allOpportunity);
			LOG.info("Found Opportunities Returning its Data");
			return allOpportunity;
		}
		catch(Exception e) {
			LOG.warn("No Opportunity Found");
			LOG.warn("Exception Occured while Finding1");
			LOG.error("Error in Finding Opportunity:"+e.toString());
			
			
			
		}
		
		
		}
		else {
			LOG.warn("User not verified");
			return null;
			
		}
	return null;
		
		
	}
	
	
	@DeleteMapping("/api/delete/{id}")
	public List<Opportunity> deleteData(@PathVariable Integer id,@RequestHeader("emailid") String emailid, @RequestHeader("token") String token) {
		LOG.info("Inside Opportunity Delete Class");
		LOG.info("Verifying User");
		
		if(interceptor.verfiyUser(emailid, token)) {
			LOG.info("User Verified");
		try {
			LOG.info("Trying to remove opportunity");
			if(!opportunityService.deleteOpportunity(id)) {
				LOG.warn("Entry not deleted");
			}
		}
		catch(Exception e) {
			
			LOG.warn("Exception Occured while Deleting");
			LOG.error("Error in Deleting Opportunity:"+e.toString());
			
		}
		LOG.info("Opportunity Removed from DB");
		return (List<Opportunity>) dao.findAll();
		}
		else {
			LOG.warn("User Not Verified");
			return null;
		}
	}
	
	@PutMapping("/api/update")
	public List<Opportunity> updateData(@RequestBody Opportunity opportunity,@RequestHeader("emailid") String emailid, @RequestHeader("token") String token){
		LOG.info("Inside Opportunity Update Class");
		
		if(interceptor.verfiyUser(emailid, token)) {
		try {
			LOG.info("Trying to Update Opportunity");
		//dao.save(opportunity);
			if(!opportunityService.updateOpportunity(opportunity)) {
				throw new OpportunityNotFoundException();
			}
		}
		catch(Exception e) {
			LOG.warn("Exception Occured while Updating");
			LOG.error("Error in Updating Opportunity:"+e.toString());
			
		
			
		}
		LOG.info("Opportunity Updated in DB");
		return opportunityService.getAllOpportunities();
		
	}
		else {
			LOG.warn("User Not Verified");
			return null;
		}
	}
	
	
	

}
