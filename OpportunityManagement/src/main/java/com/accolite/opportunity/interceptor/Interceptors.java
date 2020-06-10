package com.accolite.opportunity.interceptor;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.logging.Log4jLogger;
import com.accolite.opportunity.model.Users;
import com.accolite.opportunity.mysql.dao.UsersDao;

@Service
public class Interceptors {
	private static final Logger LOG = Log4jLogger.log;
	@Autowired 
	private UsersDao dao1;
	
	
	public boolean  verfiyUser(String emailid,String token) {
		LOG.info("verifying user");
		List<Users> allUsers = null;
		try {
			LOG.info("Trying to Find User in DB by retreiving all Users");
		 allUsers = (List<Users>) dao1.findAll();
		}catch(Exception e) {
			LOG.warn("Exception Occured while Finding");
			LOG.error("Error in Finding User:"+e.toString());
		}
		boolean userFound = false;
		
		for(Users u: allUsers) {
			if(u.getEmailid().equals(emailid) && u.getToken().equals(token)) {
				LOG.info("Found User");
				return !userFound;
				
				
				
				
			}
		}
		
		return userFound;
		
	}

}
