package com.accolite.opportunity;

import org.junit.Test;
import org.junit.runner.RunWith;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accolite.opportunity.exception.OpportunityExceptionHandler;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.mysql.dao.OpportunityDao;
import com.accolite.opportunity.web.controller.OpportunityController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
//@WebMvcTest(controllers = {OpportunityController.class})
//@SpringBootTest
class OpportunityManagementApplicationTests {
	/*@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OpportunityDao mockDao;
	

	
	ObjectMapper om = new ObjectMapper();
	
	
	
	
	
	
	
	
	@Before
	public void setUp() {
		
		 
		 //mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		 
	}
	@Test
	public void addOpportunityDataTest() throws Exception {
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
		String jsonRequest = null;
		
		
			jsonRequest = om.writeValueAsString(opp);
			System.out.println("req = "+jsonRequest);
			
			mockMvc.perform(post("/api/create").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE));
			//andExpect(status().isOk());
		
		
		
		
		
		
		
	}
	@Test
	public void getAllTheOpportunity() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(Mockito.anyList());
		
		
	String results = mockMvc.perform(MockMvcRequestBuilders.get("/api/get"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print())
		.andReturn().getResponse().getContentAsString();
		System.out.println("[Result:] "+results);
	}
	
	@Test
	public void deleteTheOpportunityById() throws Exception{
		when(mockDao.findAll()).thenReturn(Mockito.anyList());
		
		String results = mockMvc.perform(MockMvcRequestBuilders.delete("/api/delete/2"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print())
		.andReturn().getResponse().getContentAsString();
		System.out.println("[Result:] "+results);
		
		
		
		
	}
	
	
	
	@Test
	public void updateOpportunityDataTest() throws Exception {
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
		String jsonRequest = null;
		
		
			jsonRequest = om.writeValueAsString(opp);
			System.out.println("req1 = "+jsonRequest);
			
			mockMvc.perform(put("/api/update").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE));
			//andExpect(status().isOk());
		
		
		
		
		
		
		
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	

	@Test
	void contextLoads() {
	}

}
