package com.accolite.opportunity.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.accolite.logging.Log4jLogger;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.mysql.dao.OpportunityDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Component
public class OpportunityScrapper {
	private static final Logger LOG = Log4jLogger.log;
	@Autowired
	private OpportunityDao opportunityDao;
	
	private Date currentDate;
	
	@Scheduled(cron="0 0 0 * * ?")
	public void scheduleTaskToPerformOpportunityScrapping() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Calendar today = Calendar.getInstance();
		//System.out.println("Here"+today.get(Calendar.YEAR));
		currentDate = dateFormat.parse(today.get(Calendar.YEAR)+"-"+(today.get(Calendar.MONTH)+1)+"-"+today.get(Calendar.DAY_OF_MONTH));
		List<Opportunity> allOpportunities = null;
		allOpportunities = (List<Opportunity>) opportunityDao.findAll();
		
		Date opportunityDates;
		for(Opportunity opportunity:allOpportunities) {
			
			//LocalDate localDate1 = (LocalDate) formatter.parse(opportunity.getLastdatetoapply().substring(0,10));
			
			opportunityDates = dateFormat.parse(opportunity.getLastdatetoapply().substring(0,10));
			//System.out.println("Compare"+opportunityDates+" "+currentDate+" "+opportunityDates.before(currentDate));
			if(opportunityDates.before(currentDate)) {
				opportunityDao.deleteById(opportunity.getOpportunityid());
				//System.out.println("Deleted Entry"+opportunity);
				LOG.warn("Scrapped Opportunity"+opportunity);
			}

			
		}
		
		
		
		
	}

}
