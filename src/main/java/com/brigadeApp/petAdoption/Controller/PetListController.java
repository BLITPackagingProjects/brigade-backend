package com.brigadeApp.petAdoption.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brigadeApp.petAdoption.Entity.Pet;
import com.brigadeApp.petAdoption.Service.PetListInterface;

@RestController
public class PetListController {

	@Autowired
	private PetListInterface petListInter;
	
	@GetMapping("/pet")
	public List<Pet> petList(){
	return petListInter.getPet();
			
			
				
				
			
				}
	
	}

