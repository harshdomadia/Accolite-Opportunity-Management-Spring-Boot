package com.accolite.opportunity.web.controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.accolite.logging.Log4jLogger;
import com.accolite.opportunity.model.Users;
import com.accolite.opportunity.mysql.dao.UsersDao;

import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class UsersController {
	
	
	
	private static final Logger LOG = Log4jLogger.log;
	@Autowired 
	private UsersDao dao1;
	@PostMapping("/api/addUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Users> addUsers(@RequestBody Users user) {
		LOG.info("Inside User Add Class for Interceptor");
		try {
			LOG.info("Trying to Register User into DB");
		dao1.save(user);
		
		}
		catch(Exception e) {
			LOG.warn("Exception Occured while Adding");
			LOG.error("Error in Adding User:"+e.toString());
			
		}
		LOG.info("User Registered into DB");
		return (List<Users>) dao1.findAll();
		
		
	}
	@GetMapping("/api/getUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public Users getUsers(@RequestParam(value = "emailid") String emailid){
		LOG.info("Inside User Get Class for finding User by EmailId");
		List<Users> allUsers = null;
		try {
			LOG.info("Trying to Find User in DB by retreiving all data");
		 allUsers = (List<Users>) dao1.findAll();
		}
		catch(Exception e) {
			LOG.warn("Exception Occured while Finding");
			LOG.error("Error in Finding User:"+e.toString());
		}
		
		for(Users u: allUsers) {
			if(u.getEmailid().equals(emailid)) {
				LOG.info("Found User Returning its Data");
				return u;
			}
		}
		
		
		LOG.info("User Not Found in DB");
		return null;
	}
	
	@DeleteMapping("/api/deleteUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Users> deleteUsers(@PathVariable Integer id) {
		LOG.info("Inside User Delete Class for Removing User");
		
		try {
			LOG.info("Trying to remove User");
		dao1.deleteById(id);
		}
		catch(Exception e) {
			LOG.warn("Exception Occured while Deleting");
			LOG.error("Error in Deleting User:"+e.toString());
		
			
		}
		LOG.info("User Removed from DB");
		return (List<Users>) dao1.findAll();
	}
	
	@PutMapping("/api/updateUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Users> updateUsers(@RequestBody Users user){
		LOG.info("Inside User Update Class for Updating User");
		try {
			LOG.info("Trying to Update User");
		dao1.save(user);
		}catch(Exception e) {
			LOG.warn("Exception Occured while Updating");
			LOG.error("Error in Updating User:"+e.toString());
		
			
		}
		LOG.info("User Updated in DB");
		return (List<Users>) dao1.findAll();
		
	}
	
	

}
