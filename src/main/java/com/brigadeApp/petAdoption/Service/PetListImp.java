package com.brigadeApp.petAdoption.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.brigadeApp.petAdoption.DAO.PetListDao;
import com.brigadeApp.petAdoption.Entity.Pet;

public class PetListImp implements PetListInterface{
	@Autowired
	private PetListDao petlistDao;
	@Override
	public List<Pet> getPet() {
		return petlistDao.findAll();

}
}