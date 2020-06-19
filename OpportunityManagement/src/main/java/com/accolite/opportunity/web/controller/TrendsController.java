package com.accolite.opportunity.web.controller;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.logging.Log4jLogger;
import com.accolite.opportunity.interceptor.Interceptors;
import com.accolite.opportunity.services.TrendsService;



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
