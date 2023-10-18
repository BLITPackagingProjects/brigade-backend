package com.brigadeApp.petAdoption.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.brigadeApp.petAdoption.DAO.ApplciationRepo;
import com.brigadeApp.petAdoption.DAO.PetRepo;
import com.brigadeApp.petAdoption.DAO.UserRepo;
import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Entity.Pet;
import com.brigadeApp.petAdoption.Entity.User;

public class ApplicationService {

    @Autowired
    ApplciationRepo applciationRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    PetRepo petRepo;

    public List<Application> showListOfAppFor(int role_id, long id) {
        List<User> userlList = userRepo.findUsersByRole(role_id);
        User newUser = null;
        for (User objUser : userlList) {
            if (objUser.getUser_id() == id) {
                newUser = objUser;
            }

        }
        return newUser.getApplicationLis();
    }

    public Application createApplication(long pet_id, Application application, long cust_id) {

        Pet pet = petRepo.findById(pet_id).orElseThrow(() -> new RuntimeException("Pet not found"));

        User user = userRepo.findById(cust_id).orElseThrow(() -> new RuntimeException("Customer not found"));

        application.setUser(user);
        application.setPet(pet);
        applciationRepo.save(application);
        return application;

    }

}
