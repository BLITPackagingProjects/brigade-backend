package com.brigadeApp.petAdoption.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brigadeApp.petAdoption.Entity.Application;

public interface CustomerRepo extends JpaRepository <Application , Long> {

	

}
