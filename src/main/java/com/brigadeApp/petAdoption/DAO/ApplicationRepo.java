package com.brigadeApp.petAdoption.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.brigadeApp.petAdoption.Entity.Application;



@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {

//	 void save(Application application);
	
}
