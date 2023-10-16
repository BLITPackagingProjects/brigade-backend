package com.brigadeApp.petAdoption.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brigadeApp.petAdoption.DAO.UserDao;
import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Entity.User;
import com.brigadeApp.petAdoption.Entity.UserRole;

@Service
public class UserServiceImo implements UserService {
	
	@Autowired
	private UserDao userdao;

	@Override
	public User createUser(User user) {
       return userdao.save(user);    
		
	}


	


}
