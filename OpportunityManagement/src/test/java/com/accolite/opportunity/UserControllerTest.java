package com.accolite.opportunity;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.accolite.opportunity.model.Users;
import com.accolite.opportunity.mysql.dao.UsersDao;
import com.accolite.opportunity.web.controller.UsersController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {UsersController.class})
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UsersDao mockDao;
	
	ObjectMapper om = new ObjectMapper();
	
	
	
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
			
		
		
		
		
		
		
		
	}
	@Test
	public void getAllUserstest() throws Exception{
		
		Users user = new Users();
		user.setUserid(12);
		user.setEmailid("harshdomadia@accoliteindia.com");
		user.setToken("hfsfiorfgiofhuiadofhdisahfiofhdioshafuisdfodhafusdhguisdhsidudfhidfuidghuiashfiushifgrdia");
		List<Users> userList = new ArrayList<>();
		userList.add(user);
		when(mockDao.findAll()).thenReturn(userList);
		
		
		
		
		
	String results = mockMvc.perform(MockMvcRequestBuilders.get("/api/getUser").param("emailid","harshdoamdia@accoliteindia.com"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andDo(print())
		.andReturn().getResponse().getContentAsString();
		System.out.println("[Result:] "+results);
	}
	

	
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
			
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
