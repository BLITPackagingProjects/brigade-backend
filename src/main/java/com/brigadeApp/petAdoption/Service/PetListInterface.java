package com.brigadeApp.petAdoption.Service;

import java.util.List;

import com.brigadeApp.petAdoption.Entity.Pet;

public interface PetListInterface {

	public List<Pet> getPet();

	public List<Pet> addPet(Pet pet);

	

}
