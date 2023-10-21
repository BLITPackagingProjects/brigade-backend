package com.brigadeApp.petAdoption.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Service.ApplicationService;

@RestController
public class ApplicationController {
	@Autowired
	private ApplicationService applicationService;

	
	
  @PostMapping("/{userId}/{petId}")
  public Application createApp(@RequestBody Application application, @PathVariable("userId") long userId, @PathVariable("petId") long petId){
 return applicationService.createApplication(petId,application,userId);
  }
  
  @GetMapping("/{id}/{empId}")
  public List<Application> getAllApplicationsForUser(@PathVariable("id") int id, @PathVariable("empId") long empId) {
      return applicationService.showListOfAppFor(id, empId);
}
 
  @GetMapping
  public List<Application> getAllApplicationsForUser() {
      return applicationService.showListOfAppFor();
  }
 
}
// @PostMapping("/Application/{id}")
//	public void adoptionApplication(@PathVariable long id,@RequestBody Application application ) {
//		applicationService.addApplication (application, id, id);
//	}
//	
	    //@GetMapping
//	    //to see application by using user id 
//	@GetMapping("/user/{id}")
//		public seeApplication <Application> getUserById(@PathVariable long id,@RequestBody User user){
//		return applicationService.getUserById(id);
		
	
	
	
