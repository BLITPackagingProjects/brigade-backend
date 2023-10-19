package com.brigadeApp.petAdoption.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brigadeApp.petAdoption.Entity.User;
import com.brigadeApp.petAdoption.Service.UserService;
import com.brigadeApp.petAdoption.Service.UserServiceImo;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	

	@PostMapping("/user")
	public User createuser(@RequestBody User user) {
		return userservice.createUser(user);
		
	}
	
	
	}
	

