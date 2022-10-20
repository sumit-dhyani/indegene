package com.assignment.Indegene.controller;
import com.assignment.Indegene.entity.Project;
import com.assignment.Indegene.entity.ProjectDetails;
import com.assignment.Indegene.serviceimpl.ApiServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ApiController {

    private final ApiServiceImpl apiService;

    public ApiController(ApiServiceImpl apiService){
        this.apiService=apiService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectDetails>> getAllDetails(){
        List<ProjectDetails> project= apiService.getAllProjectDetails();
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectDetails> setNewProject(@RequestBody ProjectDetails projectDetails){
        ProjectDetails projectDetails1=apiService.saveProjectDetails(projectDetails);
        return new ResponseEntity<>(projectDetails1, HttpStatus.OK);
    }
    @GetMapping("project/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id){
        Project project=apiService.getProjectById(id);
        return new ResponseEntity<>(project,HttpStatus.OK);
    }
    @GetMapping("project")
    public ResponseEntity<List<Project>> getProject(){
        List<Project> projects=apiService.getAllProjects();
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<ProjectDetails> getProjectDetailsById(@PathVariable long id){
        ProjectDetails projectDetails=apiService.getProjectDetailsById(id);
        return new ResponseEntity<>(projectDetails,HttpStatus.OK);
    }
}
