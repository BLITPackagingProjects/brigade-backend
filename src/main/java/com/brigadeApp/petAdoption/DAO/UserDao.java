package com.brigadeApp.petAdoption.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Entity.User;
@Repository
public interface UserDao extends JpaRepository <User , Long> {

	
	
	
}
