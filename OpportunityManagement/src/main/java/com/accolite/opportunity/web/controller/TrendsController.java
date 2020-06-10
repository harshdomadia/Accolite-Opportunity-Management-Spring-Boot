package com.accolite.opportunity.web.controller;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.logging.Log4jLogger;
import com.accolite.opportunity.interceptor.Interceptors;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.services.TrendsService;

import org.springframework.web.bind.annotation.*;

//import com.accolite.opportunity.interceptor.Interceptors;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class TrendsController {
	private static final Logger LOG = Log4jLogger.log;
	
	@Autowired
	TrendsService trendsService;
	
	@Autowired
	private Interceptors interceptor;
	
	@GetMapping("/api/getTrends1")
	@CrossOrigin(origins = "http://localhost:4200")
	public Map<String,Map<String,Integer>> getData(@RequestHeader("emailid") String emailid, @RequestHeader("token") String token){
//		String log4jConfPath = "C:/Users/wel/eclipse-workspace/OpportunityManagement/log4j.properties";
//		PropertyConfigurator.configure(log4jConfPath);
		
		
		LOG.info("Inside Opportunity Get Class");
		LOG.info("verifying user");
	if(interceptor.verfiyUser(emailid, token))
		{
		Map<String,Map<String,Integer>> allTrends=null;
		try {
			LOG.info("Trying to Find User in DB by retreiving all data");
			allTrends = trendsService.getTrendsForLanguageCount();
			LOG.info("Found Opportunities Returning its Data");
			return allTrends;
		}
		catch(Exception e) {
			LOG.warn("Exception Occured while Finding");
			LOG.error("Error in Finding Opportunity:"+e.toString());
			
		}
		LOG.warn("No Opportunity Found");
		return null;
		}
		else {
			LOG.warn("User not verified");
			return null;
			
		}
		
		
	}
	
	

}
