package com.assignment.Indegene.controller;
import com.assignment.Indegene.entity.ProjectDetails;
import com.assignment.Indegene.exceptions.ChannelNotFoundException;
import com.assignment.Indegene.service.ApiService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
public class ProjectDetailsController {

    private final ApiService apiServiceImpl;
    private final String channelName="channelName";
    private final String projectId="{id}";
    private final Logger LOGGER= LoggerFactory.getLogger(ProjectDetailsController.class);

    public ProjectDetailsController(ApiService apiServiceImpl){
        this.apiServiceImpl=apiServiceImpl;
    }

    @GetMapping
    @RolesAllowed("Admin")
    @Operation(tags = "Project Details Api",
    summary = "Get all project details")
    public ResponseEntity<List<ProjectDetails>> getAllDetails(@RequestParam(name = channelName,required = false) String name){
        if(name!=null){
            List<ProjectDetails> projectDetails=apiServiceImpl.getProjectDetailsByChannelName(name);
            if(projectDetails.isEmpty()){
                LOGGER.error("Channel with name "+name+" not found");
                throw new ChannelNotFoundException("Channel with name "+name+" Not found");
            }
            return new ResponseEntity<>(projectDetails,HttpStatus.OK);
        }
        List<ProjectDetails> project= apiServiceImpl.getAllProjectDetails();
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @GetMapping(projectId)
    @RolesAllowed("Admin")
    @Operation(tags = "Project Details Api",
    summary = "Get Project details by Project Id")
    @ResponseStatus(HttpStatus.OK)
    public ProjectDetails getProjectDetailsById(@PathVariable long id){
        ProjectDetails projectDetails=apiServiceImpl.getProjectDetailsById(id);
        return projectDetails;
    }
}
