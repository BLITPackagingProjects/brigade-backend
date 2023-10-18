package com.brigadeApp.petAdoption.Controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.brigadeApp.petAdoption.Entity.Pet;
import com.brigadeApp.petAdoption.Service.PetImpl;


@RestController
//@CrossOrigin("http://localhost:3000")
public class PetDetailsController {
	
	@Autowired
	PetImpl petImpl;
	
	@GetMapping("/pet/{id}")
	public ResponseEntity<Pet> petDetails(@PathVariable Long id){
		return new ResponseEntity<>(petImpl.petDetails(id), HttpStatus.OK);
	}

}
