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

import com.accolite.opportunity.mysql.dao.OpportunityDao;
import com.accolite.opportunity.trends.models.TrendsLanguageCount;
//import com.accolite.opportunity.mysql.dao.UsersDao;

@Service
public class TrendsService {
	
	@Autowired
	private OpportunityDao opportunityDao;
	
	public Map<String,Map<String,Integer>> getTrendsForLanguageCount(){
		Map<String,Map<String,Integer>> trendsCount = new HashMap<>();
		List<Opportunity> allOpportunity =null;
		try {
			allOpportunity = (List<Opportunity>) opportunityDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Opportunity opp:allOpportunity) {
			if(!trendsCount.containsKey(opp.getSkills())) {
				String year = opp.getLastdatetoapply().substring(0, 4);
				Map<String,Integer> yearData = new HashMap<>();
				yearData.put(year,1);
				trendsCount.put(opp.getSkills(), yearData);
			}
			else {
				String year = opp.getLastdatetoapply().substring(0, 4);
				Integer i = trendsCount.get(opp.getSkills()).get(year);
				trendsCount.get(opp.getSkills()).put(year, i++);
			}
			
		}
		System.out.println(trendsCount);
		
		return trendsCount;
		
		
	}
	

}
