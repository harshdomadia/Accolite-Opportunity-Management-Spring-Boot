package com.accolite.opportunity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.accolite.opportunity.interceptor.Interceptors;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.mysql.dao.OpportunityDao;
import com.accolite.opportunity.services.OpportunityService;
import com.accolite.opportunity.services.TrendsService;


@SpringBootTest
public class TrendsServiceTest {
	
	
	
	@MockBean
	private OpportunityDao mockDao;
	
	@Autowired
	private TrendsService trendsService;
	
	@MockBean
	private Interceptors mockinterceptor;
	
	@MockBean
	private OpportunityService mockService;
	
	
	
	@Test
	public void getAllTheTrends() throws Exception{
		Opportunity opp = new Opportunity();
		opp.setOpportunityid(1);
		opp.setOpportunitydescription("Kotlin Project");
		opp.setLocation("Delhi");
		opp.setSkills("Kotlin");
		opp.setExperience(3);
		opp.setOpeningcount(2);
		opp.setProjectduration(4);
		opp.setLastdatetoapply("2020-07-07");
		opp.setManagername("Harsh1");
		opp.setManageremail("harshdomadia1@accoliteindia.com");
		opp.setCreateremail("harshdomadia@accoliteindia.com");
		
		Opportunity opp1 = new Opportunity();
		opp1.setOpportunityid(5);
		opp1.setOpportunitydescription("Kotlin Project");
		opp1.setLocation("Delhi");
		opp1.setSkills("Kotlin");
		opp1.setExperience(3);
		opp1.setOpeningcount(2);
		opp1.setProjectduration(4);
		opp1.setLastdatetoapply("2020-07-07");
		opp1.setManagername("Harsh1");
		opp1.setManageremail("harshdomadia1@accoliteindia.com");
		opp1.setCreateremail("harshdomadia@accoliteindia.com");
		
		List<Opportunity> testOpportunities = new ArrayList<>();
		testOpportunities.add(opp);
		testOpportunities.add(opp1);
		
		
		when(mockService.getAllOpportunities()).thenReturn(testOpportunities);
		
		trendsService.getTrendsForLanguageCount();
		verify(mockService,times(1)).getAllOpportunities();
		 assertThat(trendsService.getTrendsForLanguageCount()).isNotNull();
	}

}
