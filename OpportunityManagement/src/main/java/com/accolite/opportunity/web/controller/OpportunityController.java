package com.accolite.opportunity.web.controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.opportunity.model.Opportunity;

import com.accolite.opportunity.mysql.dao.OpportunityDao;

import org.springframework.web.bind.annotation.*;
import com.accolite.logging.Log4jLogger;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OpportunityController {
	private static final Logger LOG = Log4jLogger.log;
	@Autowired 
	private OpportunityDao dao;
	@PostMapping("/api/create")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Opportunity> addData(@RequestBody Opportunity opportunity) {
		
		LOG.info("Inside Opportunity Add Class");
		try {
		dao.save(opportunity);
		}catch(Exception e) {
			LOG.warn("Exception Occured while Adding");
			LOG.error("Error in Adding Opportunityr:"+e.toString());
		}
		LOG.info("Opportunity Registered into DB");
		return (List<Opportunity>) dao.findAll();
		
		
	}
	@GetMapping("/api/get")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Opportunity> getData(){
//		String log4jConfPath = "C:/Users/wel/eclipse-workspace/OpportunityManagement/log4j.properties";
//		PropertyConfigurator.configure(log4jConfPath);
		LOG.info("Inside Opportunity Get Class");
		List<Opportunity> allOpportunity=null;
		try {
			LOG.info("Trying to Find User in DB by retreiving all data");
			allOpportunity = (List<Opportunity>) dao.findAll();
			LOG.info("Found Opportunities Returning its Data");
			return allOpportunity;
		}
		catch(Exception e) {
			LOG.warn("Exception Occured while Finding");
			LOG.error("Error in Finding Opportunity:"+e.toString());
			
		}
		LOG.warn("No Opportunity Found");
		return null;
		
		
	}
	
	
	@DeleteMapping("/api/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Opportunity> deleteData(@PathVariable Integer id) {
		LOG.info("Inside Opportunity Delete Class");
		try {
			LOG.info("Trying to remove opportunity");
		dao.deleteById(id);
		}
		catch(Exception e) {
			LOG.warn("Exception Occured while Deleting");
			LOG.error("Error in Deleting Opportunity:"+e.toString());
		
		}
		LOG.info("Opportunity Removed from DB");
		return (List<Opportunity>) dao.findAll();
	}
	
	@PutMapping("/api/update")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Opportunity> updateData(@RequestBody Opportunity opportunity){
		LOG.info("Inside Opportunity Update Class");
		try {
			LOG.info("Trying to Update Opportunity");
		dao.save(opportunity);
		}
		catch(Exception e) {
			LOG.warn("Exception Occured while Updating");
			LOG.error("Error in Updating Opportunity:"+e.toString());
		
			
		}
		LOG.info("Opportunity Updated in DB");
		return (List<Opportunity>) dao.findAll();
		
	}
	
	
	

}
