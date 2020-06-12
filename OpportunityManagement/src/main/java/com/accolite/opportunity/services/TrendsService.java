package com.accolite.opportunity.services;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.accolite.logging.Log4jLogger;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.web.controller.OpportunityController;


//import com.accolite.opportunity.mysql.dao.UsersDao;

@Service
public class TrendsService {
	
	@Autowired
	private OpportunityService opportunityService;
	
//	@Autowired
//	private OpportunityController opportunityController;
	
	public Map<String,Map<String,Integer>> getTrendsForLanguageCount(){
		Map<String,Map<String,Integer>> trendsCount = new HashMap<>();
		List<Opportunity> allOpportunity =null;
		System.out.println("Inside Opportunity Service");
		try {
			allOpportunity = (List<Opportunity>) opportunityService.getAllOpportunities();
			System.out.println("All opp"+allOpportunity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Opportunity opp:allOpportunity) {
			if(!trendsCount.containsKey(opp.getSkills())) {
				System.out.println("Skill"+opp.getSkills());
				String year = opp.getLastdatetoapply().substring(0, 4);
				System.out.println("Year"+year);
				Map<String,Integer> yearData = new HashMap<>();
				yearData.put(year,1);
				System.out.println("YearData"+yearData);
				trendsCount.put(opp.getSkills(), yearData);
				System.out.println("trendsCount"+trendsCount);
				
			}
			else {
				System.out.println("Skill1"+opp.getSkills());
				String year = opp.getLastdatetoapply().substring(0, 4);
				if(trendsCount.get(opp.getSkills()).containsKey(year)) {
				System.out.println("Year1"+year);
				Integer i = trendsCount.get(opp.getSkills()).get(year);
				System.out.println("CountI"+i);
				trendsCount.get(opp.getSkills()).put(year, ++i);
				System.out.println("trendsCount1"+trendsCount);
				}
				else {
					trendsCount.get(opp.getSkills()).put(year,1);
				}

			}
			
		}
		System.out.println("From trends Count"+trendsCount);
		
		return trendsCount;
		
		
	}
	

}
