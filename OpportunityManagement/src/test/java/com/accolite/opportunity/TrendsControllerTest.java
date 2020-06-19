package com.accolite.opportunity;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.accolite.opportunity.interceptor.Interceptors;
import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.mysql.dao.OpportunityDao;
import com.accolite.opportunity.services.TrendsService;
import com.accolite.opportunity.web.controller.TrendsController;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = {TrendsController.class})
public class TrendsControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private OpportunityDao mockDao;
	
	
	@MockBean
	private Interceptors mockinterceptor;
	
	@MockBean
	private TrendsService mockService;
	

	
	ObjectMapper om = new ObjectMapper();
	
	@Test
	public void getAllTheTestsFromController() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(new ArrayList<Opportunity>());
		when(mockinterceptor.verfiyUser("harshdoamdia@accoliteindia.com", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega")).thenReturn(Boolean.TRUE);
		
		
	String results = mockMvc.perform(MockMvcRequestBuilders.get("/api/getTrends1").header("emailid", "harshdoamdia@accoliteindia.com").header("token", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print())
		.andReturn().getResponse().getContentAsString();
		System.out.println("[Result:] "+results);
	}
	
	@Test
	public void getAllTheFailTestsForInterceptorFromController() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(new ArrayList<Opportunity>());
		when(mockinterceptor.verfiyUser("harshddia@accoliteindia.com", "pdhifhighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega")).thenReturn(Boolean.TRUE);
		
		
	String results = mockMvc.perform(MockMvcRequestBuilders.get("/api/getTrends1").header("emailid", "harshdoamdia@accoliteindia.com").header("token", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print())
		.andReturn().getResponse().getContentAsString();
		System.out.println("[Result:] "+results);
	}
	
	@Test
	public void getAllTheTestsForNullDataFromController() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(null);
		when(mockinterceptor.verfiyUser("harshdoamdia@accoliteindia.com", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega")).thenReturn(Boolean.TRUE);
		
		
	String results = mockMvc.perform(MockMvcRequestBuilders.get("/api/getTrends1").header("emailid", "harshdoamdia@accoliteindia.com").header("token", "pdhifhighighweghoifwwghoifhgihfgihrghiehgqaehrgihfigoag'orega"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print())
		.andReturn().getResponse().getContentAsString();
		System.out.println("[Result:] "+results);
	}
	
	
	
	

}
