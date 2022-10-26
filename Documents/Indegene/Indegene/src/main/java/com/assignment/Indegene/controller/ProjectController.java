package com.assignment.Indegene.controller;

import com.assignment.Indegene.entity.Project;
import com.assignment.Indegene.service.ApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProjectController {
    private final ApiService apiServiceImpl;

    public ProjectController(ApiService apiServiceImpl){
        this.apiServiceImpl=apiServiceImpl;
    }
    @GetMapping("project/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id){
        Project project=apiServiceImpl.getProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }
    @GetMapping("project")
    public ResponseEntity<List<Project>> getProject(){
        List<Project> projects=apiServiceImpl.getAllProjects();
        return new ResponseEntity<>(projects,HttpStatus.OK);
    }
}
