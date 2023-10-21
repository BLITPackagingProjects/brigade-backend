package com.brigadeApp.petAdoption.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brigadeApp.petAdoption.Entity.Pet;

public interface PetRepo extends JpaRepository<Pet, Long> {

}
