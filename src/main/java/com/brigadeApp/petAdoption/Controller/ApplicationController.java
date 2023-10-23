package com.brigadeApp.petAdoption.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @PutMapping("/update/{id}")
	public Application updateApplication(@RequestBody Application app, @PathVariable Long id) {
		return applicationService.updateApplication(app, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteApplicationById(@PathVariable Long id) {
		applicationService.deleteById(id);
	}
}
