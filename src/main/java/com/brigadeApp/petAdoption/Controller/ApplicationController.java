package com.brigadeApp.petAdoption.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Service.ApplicationService;

@CrossOrigin
@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping
    public List<Application> getAllApplicationsForUser() {
        return applicationService.showListOfAppFor();

    }

    @PostMapping("/{userId}/{petId}")
    public Application createApp(@RequestBody Application application, @PathVariable("userId") long userId,
            @PathVariable("petId") long petId) {
        return applicationService.createApplication(petId, application, userId);
    }
}
