package com.accolite.opportunity;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.accolite.opportunity.interceptor.Interceptors;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.mysql.dao.OpportunityDao;
import com.accolite.opportunity.services.OpportunityService;
import com.accolite.opportunity.web.controller.OpportunityController;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = {OpportunityService.class})
@SpringBootTest
public class OpportunityServiceTest {
	
	private static final int Optional = 0;

	@Autowired
	private OpportunityService opportunityService;
	
	@MockBean
	private OpportunityDao mockDao;
	
	
	
	@Test
	public void getAllTheOpportunity() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(new ArrayList<Opportunity>());
		//when(mockinterceptor.verfiyUser("harshdoamdia@accoliteindia.com", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega")).thenReturn(Boolean.TRUE);
		
		opportunityService.getAllOpportunities();
		verify(mockDao,times(1)).findAll();
	}
	@Test
	public void deleteTheOpportunity() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(new ArrayList<Opportunity>());
		//when(mockDao.deleteById(new Integer(1))).thenReturn(new ArrayList<Opportunity>());
		//when(mockinterceptor.verfiyUser("harshdoamdia@accoliteindia.com", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega")).thenReturn(Boolean.TRUE);
		
		opportunityService.deleteOpportunity(new Integer(17));
		verify(mockDao,times(1)).deleteById(new Integer(17));;
	}

	@Test
	public void updateTheOpportunity() throws Exception{
		
		Opportunity opp = new Opportunity();
		opp.setOpportunityid(new Integer(1));
		opp.setOpportunitydescription("Kotlin Project");
		opp.setLocation("Delhi");
		opp.setSkills("Kotlin");
		opp.setExperience(3);
		opp.setOpeningcount(2);
		opp.setProjectduration(4);
		opp.setLastdatetoapply("2020-07-08");
		opp.setManagername("Harsh");
		opp.setManageremail("harshdomadia@accoliteindia.com");
		opp.setCreateremail("harshdomadia@accoliteindia.com");
		
		
		when(mockDao.findAll()).thenReturn(new ArrayList<Opportunity>());
		//when(mockinterceptor.verfiyUser("harshdoamdia@accoliteindia.com", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega")).thenReturn(Boolean.TRUE);
		
		when(((Optional<Opportunity>) mockDao.findById(Mockito.anyInt())).isPresent()).thenReturn(Boolean.TRUE);
		opportunityService.updateOpportunity(opp);
		verify(mockDao,times(1)).save(opp);
	}

	@Test
	public void addTheOpportunityPass() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(new ArrayList<Opportunity>());
		//when(mockinterceptor.verfiyUser("harshdoamdia@accoliteindia.com", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega")).thenReturn(Boolean.TRUE);
		
		Opportunity opp = new Opportunity();
		opp.setOpportunityid(1);
		opp.setOpportunitydescription("Kotlin Project");
		opp.setLocation("Delhi");
		opp.setSkills("Kotlin");
		opp.setExperience(3);
		opp.setOpeningcount(2);
		opp.setProjectduration(4);
		opp.setLastdatetoapply("2020-07-07");
		opp.setManagername("Harsh");
		opp.setManageremail("harshdomadia@accoliteindia.com");
		opp.setCreateremail("harshdomadia@accoliteindia.com");
		opportunityService.addOpportunity(opp);
		verify(mockDao,times(1)).save(opp);
	}
	
	@Test
	public void addTheOpportunityFail() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(new ArrayList<Opportunity>());
		//when(mockinterceptor.verfiyUser("harshdoamdia@accoliteindia.com", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega")).thenReturn(Boolean.TRUE);
		
		Opportunity opp = new Opportunity();
		opp.setOpportunityid(1);
		opp.setOpportunitydescription("Kotlin Project");
		opp.setLocation("Delhi");
		opp.setSkills("Kotlin");
		opp.setExperience(3);
		opp.setOpeningcount(2);
		opp.setProjectduration(4);
		opp.setLastdatetoapply("2020-07-07");
		opp.setManagername("Harsh");
		opp.setManageremail("harshdomadia@accoliteindia.com");
		opp.setCreateremail("harshdomadia@accoliteindia.com");
		opportunityService.addOpportunity(new Opportunity());
		verify(mockDao,times(1)).save(new Opportunity());
	}



}
