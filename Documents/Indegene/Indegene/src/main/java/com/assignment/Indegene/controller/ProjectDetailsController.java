package com.assignment.Indegene.controller;
import com.assignment.Indegene.entity.ProjectDetails;
import com.assignment.Indegene.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectDetailsController {

    private final ApiService apiServiceImpl;

    public ProjectDetailsController(ApiService apiServiceImpl){
        this.apiServiceImpl=apiServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDetails>> getAllDetails(@RequestParam(name = "channelName",required = false) String name){
        if(name!=null){
            return new ResponseEntity<>(apiServiceImpl.getProjectDetailsByChannelName(name),HttpStatus.OK);
        }
        List<ProjectDetails> project= apiServiceImpl.getAllProjectDetails();
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectDetails> setNewProject(@RequestBody ProjectDetails projectDetails){
        ProjectDetails projectDetails1=apiServiceImpl.saveProjectDetails(projectDetails);
        return new ResponseEntity<>(projectDetails1, HttpStatus.OK);
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ProjectDetails getProjectDetailsById(@PathVariable long id){
        ProjectDetails projectDetails=apiServiceImpl.getProjectDetailsById(id);
        return projectDetails;
    }
}
