package com.brigadeApp.petAdoption.Service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.brigadeApp.petAdoption.DAO.ApplicationRepo;
import com.brigadeApp.petAdoption.DAO.PetRepo;
import com.brigadeApp.petAdoption.DAO.UserRepo;
import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Entity.Pet;
import com.brigadeApp.petAdoption.Entity.User;

@Service
public interface ApplicationService {

    @Autowired
    ApplicationRepo applicationRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PetRepo petRepo;

    List<Application> showListOfAppFor(int role_id, long id);

    List<Application> showListOfAppFor();

    
    public Application createApplication(long pet_id, Application application, long cust_id) {

        Pet pet = petRepo.findById(pet_id).orElseThrow(() -> new RuntimeException("Pet not found"));

        User user = userRepo.findById(cust_id).orElseThrow(() -> new RuntimeException("Customer not found"));

        application.setUser(user);
        application.setPet(pet);
        application.setDate(new Date());
        applicationRepo.save(application);
        return application;

    }

	}

}