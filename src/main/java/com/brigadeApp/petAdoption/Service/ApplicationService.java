package com.brigadeApp.petAdoption.Service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.brigadeApp.petAdoption.DAO.ApplciationRepo;
import com.brigadeApp.petAdoption.DAO.PetRepo;
import com.brigadeApp.petAdoption.DAO.UserRepo;
import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Entity.Pet;
import com.brigadeApp.petAdoption.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    @Autowired
    ApplciationRepo applciationRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PetRepo petRepo;

    public List<Application> showListOfAppFor() {
        return applciationRepo.findAll();
    }

    public List<Application> showApplicationsforCustomer(long user_id) {
        User user = userRepo.findById(user_id).get();
        return user.getApplicationLis();
    }

    public ResponseEntity<?> createApplication(long pet_id, Application application, long cust_id) {

        Pet pet = petRepo.findById(pet_id).orElseThrow(() -> new RuntimeException("Pet not found"));

        User user = userRepo.findById(cust_id).orElseThrow(() -> new RuntimeException("Customer not found"));
        for (Application appObj : pet.getApplicationList()) {

            if (appObj.getUser().getId() == cust_id) {
                return new ResponseEntity<String>("Application already exist for this pet", HttpStatus.OK);
            }

        }
        application.setUser(user);
        application.setPet(pet);
        application.setDate(new Date());
        applciationRepo.save(application);
        return new ResponseEntity<Application>(application, HttpStatus.OK);

    }
    public Application updateApp(long id, Application application1){
        Application application = applciationRepo.findById(id).get();
        application.setStatus(application1.getStatus());
        applciationRepo.save(application);
        return application;
    }

    public String deleteApp(long id){
        applciationRepo.deleteById(id);
        return "Deleted";
    }

}
