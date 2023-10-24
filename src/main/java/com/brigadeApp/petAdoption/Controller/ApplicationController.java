package com.brigadeApp.petAdoption.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{userId}")
    public List<Application> fetchApplicationsForCust(@PathVariable("userId") long userId) {
        return applicationService.showApplicationsforCustomer(userId);

    }

    @PostMapping("/{userId}/{petId}")
    public ResponseEntity<?> createApp(@RequestBody Application application, @PathVariable("userId") long userId,
            @PathVariable("petId") long petId) {
        return applicationService.createApplication(petId, application, userId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application, @PathVariable("id") long id){
        return new ResponseEntity<Application>(applicationService.updateApp(id, application), HttpStatus.OK);
    }
}
