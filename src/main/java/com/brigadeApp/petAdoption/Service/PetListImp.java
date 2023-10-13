package com.brigadeApp.petAdoption.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brigadeApp.petAdoption.DAO.PetListDao;
import com.brigadeApp.petAdoption.Entity.Pet;
@Service
public class PetListImp implements PetListInterface{
	@Autowired
	private PetListDao petListDao;
	@Override
	public List<Pet> getPet() {
		return petListDao.findAll();

}
	@Override
	public List<Pet> addPet(Pet pet) {
		return petListDao.findAll();
		
	}
}