package com.brigadeApp.petAdoption.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brigadeApp.petAdoption.Entity.Pet;
import com.brigadeApp.petAdoption.Service.PetListImp;
import com.brigadeApp.petAdoption.Service.PetListInterface;

@RestController
public class PetListController {

	@Autowired
	private PetListImp petlistimp;
	
	@GetMapping("/pet")
	public ResponseEntity<List<Pet>> petList(){
	return new ResponseEntity<List<Pet>>(petlistimp.getPet(),HttpStatus.OK);
	}
	
	@PostMapping("/pet")
	public void addCourse(@RequestBody Pet pet) {
		petlistimp.addPet(pet);
			
		}
	
	}

