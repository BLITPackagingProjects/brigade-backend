package com.brigadeApp.petAdoption.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.brigadeApp.petAdoption.DAO.UserDao;
import com.brigadeApp.petAdoption.DAO.Userrolerepo;
import com.brigadeApp.petAdoption.Entity.User;
import com.brigadeApp.petAdoption.Entity.User_Role;

@Service
public class UserServiceImo implements UserService {
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private Userrolerepo userrolerepo;
	

	@Override
	public User createUser(User user) {
		final int logRounds =12;
		user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(logRounds)));
		User_Role role = userrolerepo.findById(1).get();
		user.setRole(role);
       return userdao.save(user); 
       
		
	}


	


}
