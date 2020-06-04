package com.accolite.opportunity.web.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.accolite.opportunity.model.Users;
import com.accolite.opportunity.mysql.dao.UsersDao;

import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
public class UsersController {
	
	
	
	@Autowired 
	private UsersDao dao1;
	@PostMapping("/api/addUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Users> addUsers(@RequestBody Users user) {
		dao1.save(user);
		return (List<Users>) dao1.findAll();
		
		
	}
	@GetMapping("/api/getUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public Users getUsers(@RequestParam(value = "emailid") String emailid){
		List<Users> allUsers = (List<Users>) dao1.findAll();
		for(Users u: allUsers) {
			if(u.getEmailid().equals(emailid)) {
				return u;
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/deleteUser/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Users> deleteUsers(@PathVariable Integer id) {
		dao1.deleteById(id);
		return (List<Users>) dao1.findAll();
	}
	
	@PutMapping("/api/updateUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Users> updateUsers(@RequestBody Users user){
		dao1.save(user);
		return (List<Users>) dao1.findAll();
		
	}
	
	

}
