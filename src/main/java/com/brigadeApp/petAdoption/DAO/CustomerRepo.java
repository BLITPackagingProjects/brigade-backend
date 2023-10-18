package com.brigadeApp.petAdoption.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import org.springframework.stereotype.Repository;
import com.brigadeApp.petAdoption.Entity.Pet;

@Repository
public interface CustomerRepo extends JpaRepository<Pet, Long>{
	
	
}
