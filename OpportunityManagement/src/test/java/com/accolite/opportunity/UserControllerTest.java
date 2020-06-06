package com.accolite.opportunity;


import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import org.junit.Test;
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

import com.accolite.opportunity.model.Opportunity;
import com.accolite.opportunity.model.Users;
import com.accolite.opportunity.mysql.dao.OpportunityDao;
import com.accolite.opportunity.mysql.dao.UsersDao;
import com.accolite.opportunity.web.controller.OpportunityController;
import com.accolite.opportunity.web.controller.UsersController;
import com.accolite.response.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {UsersController.class})
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UsersDao mockDao;
	
	ObjectMapper om = new ObjectMapper();
	
	@Before
	public void setUp() {
		
		 
		 //mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		 
	}
	
	
	@Test
	public void addUsersDataTest() throws Exception {
		Users user = new Users();
		user.setUserid(12);
		user.setEmailid("harshdomadia@accoliteindia.com");
		user.setToken("hfsfiorfgiofhuiadofhdisahfiofhdioshafuisdfodhafusdhguisdhsidudfhidfuidghuiashfiushifgrdia");
		
		String jsonRequest = null;
		
		
			jsonRequest = om.writeValueAsString(user);
			System.out.println("req = "+jsonRequest);
			
			mockMvc.perform(post("/api/addUser").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE));
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
	
	
	/*@Test
	public void getUserWithEmailTest() throws Exception{
		
		
		when(mockDao.findAll()).thenReturn(Mockito.anyList());
		
		
	String results = mockMvc.perform(get("/api/getUser").param("emailid", "harshdoamdia@accoliteindia.com"))
		.andExpect(status().isOk())
		.andDo(print())
		.andReturn().getResponse().getContentAsString();
		System.out.println("[Result:] "+results);
		
		//mockMvc.perform(get("/api/addUser").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE));
	}*/
	
	
	@Test
	public void deleteTheUserById() throws Exception{
		when(mockDao.findAll()).thenReturn(Mockito.anyList());
		
		String results = mockMvc.perform(MockMvcRequestBuilders.delete("/api/deleteUser/2"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print())
		.andReturn().getResponse().getContentAsString();
		System.out.println("[Result:] "+results);
		
		
		
		
	}
	
	
	
	
	
	@Test
	public void updateUserPassDataTest() throws Exception {
		Users user = new Users();
		user.setUserid(3);
		user.setEmailid("harshdomadia@accoliteindia.com");
		user.setToken("hfsfiorfgiofhuiadofhdisahfiofhdioshafuisdfodhafusdhguisdhsidudfhidfuidghuiashfiushifgrdia");
		
		String jsonRequest = null;
		
		
			jsonRequest = om.writeValueAsString(user);
			System.out.println("req1 = "+jsonRequest);
			
			mockMvc.perform(put("/api/updateUser").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE));
			//andExpect(status().isOk());
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
