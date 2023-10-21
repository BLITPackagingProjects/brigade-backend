package com.brigadeApp.petAdoption.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brigadeApp.petAdoption.DAO.ApplicationRepo;
import com.brigadeApp.petAdoption.DAO.UserRepo;
import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Entity.User;


@Service
public class ApplicationIml implements ApplicationService{
	@Autowired
	private ApplicationRepo applicationRepo;
	
	@Override
	public Application createApplication(long pet_id, Application application, long cust_id) {
		
		return applicationRepo.save(application);
	}

	@Override
	public List<Application> showListOfAppFor(int role_id) {
		List<Application> result = new ArrayList<>();
		if (role_id == 1) {
            result.add(new Application());
		}
            return result;
	}

	@Override
	public List<Application> showListOfAppFor(int role_id, long id) {
		UserRepo userRepo;
	    List<User> userlList = userRepo.findUserByRole(role_id)
	    		User newUser = null;
        for (User objUser : userlList) {
            if (objUser.getUser_id() == id) {
                newUser = objUser;
            }

        }
        return newUser.getApplicationLis();
    public List<Application> showListOfAppFor() {
       return applciationRepo.findAll();
		
	}
//	@Override
//	public void addApplication(Application application, long user_id, long pet_id) {
//		applicationRepo.save(application);
//	}


//	@Override
//	public List<Application> showListOfAppFor() {
//		// TODO Auto-generated method stub
//		return null;
//	}


}
