package com.brigadeApp.petAdoption.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brigadeApp.petAdoption.Entity.Application;
import com.brigadeApp.petAdoption.Service.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/{id}/{empId}")
    public List<Application> getAllApplicationsForUser(@PathVariable("id") int id, @PathVariable("empId") long empId) {
        return applicationService.showListOfAppFor(id, empId);

    }

}
