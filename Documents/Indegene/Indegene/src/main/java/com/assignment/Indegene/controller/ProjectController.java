package com.assignment.Indegene.controller;

import com.assignment.Indegene.entity.Project;
import com.assignment.Indegene.service.ApiService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
@RestController

public class ProjectController {
    private final Logger LOGGER= LoggerFactory.getLogger(ProjectController.class);
    private final ApiService apiServiceImpl;
    private final String projectId="project/{id}";
    private final String project="project";

    public ProjectController(ApiService apiServiceImpl){
        this.apiServiceImpl=apiServiceImpl;
    }

    @GetMapping(projectId)
    @RolesAllowed({"User","Admin"})
    @CrossOrigin("http://localhost:8085")
    @Operation(tags = "Project Details Api",summary = "Get Project data by Id")
    public ResponseEntity<Project> getProject(@PathVariable Long id){
        Project project=apiServiceImpl.getProjectById(id);
        LOGGER.debug("sending results back to client");
        return ResponseEntity.ok(project);
    }

    @GetMapping(project)
    @RolesAllowed("Admin")
    @Operation(tags = "Project Details Api",summary = "Get all projects")
    public ResponseEntity<List<Project>> getProject(){
        List<Project> projects=apiServiceImpl.getAllProjects();
        LOGGER.debug("Sending data back to client. Fetched the Data");
        return ResponseEntity.ok(projects);
    }
}
