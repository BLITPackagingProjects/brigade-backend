package com.brigadeApp.petAdoption.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brigadeApp.petAdoption.Entity.Pet;

@RestController
public class PetDescriptionController {
	
	@GetMapping("/pet")
	public List<Pet> PetDescription(){
		return ;
		
	}

}
