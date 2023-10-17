package com.brigadeApp.petAdoption.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.brigadeApp.petAdoption.DAO.ApplciationRepo;
import com.brigadeApp.petAdoption.DAO.UserRepo;
import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Entity.User;

public class ApplicationService {

    @Autowired
    ApplciationRepo applciationRepo;

    @Autowired
    UserRepo userRepo;

    public List<Application> showListOfAppFor(int role_id) {
        User user = userRepo.findUserByRole(role_id);
        return user.getApplicationLis();
    }

}
