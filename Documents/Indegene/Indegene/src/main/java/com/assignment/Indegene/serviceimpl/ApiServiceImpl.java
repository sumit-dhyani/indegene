package com.assignment.Indegene.serviceimpl;

import com.assignment.Indegene.entity.Project;
import com.assignment.Indegene.entity.ProjectDetails;
import com.assignment.Indegene.exceptions.ChannelNotFoundException;
import com.assignment.Indegene.exceptions.RecordNotFound;
import com.assignment.Indegene.repository.ProjectDetailsRepository;
import com.assignment.Indegene.repository.ProjectRepository;
import com.assignment.Indegene.service.ApiService;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceImpl implements ApiService {
    private final Logger LOGGER= LoggerFactory.getLogger(ApiServiceImpl.class);
    private final ProjectDetailsRepository projectDetailsRepo;
    private final ProjectRepository projectRepository;
    public ApiServiceImpl(ProjectDetailsRepository projectDetailsRepo,ProjectRepository projectRepository){
        this.projectDetailsRepo=projectDetailsRepo;
        this.projectRepository=projectRepository;
    }
    public List<ProjectDetails> getAllProjectDetails(){
        return projectDetailsRepo.findAll();
    }
    public ProjectDetails saveProjectDetails(ProjectDetails projectDetails){
        return projectDetailsRepo.save(projectDetails);
    }

    public Project getProjectById(Long id){
        LOGGER.info("Request Information from Database by Id :"+id);
        Optional<Project> projectData=projectRepository.findById(id);
        if(projectData.isPresent()){
            LOGGER.info("Received the data sending it back to controller ....");
            return projectData.get();
        }
        else{
            LOGGER.error("Record with id:"+id+" not found");
            throw new RecordNotFound("Project with id "+ id + " not found");
        }
    }

    public List<Project> getAllProjects() {
        LOGGER.info("Fetching all data from the Repository");
        return projectRepository.findAll();
    }

    public ProjectDetails getProjectDetailsById(long id) {
       Optional<ProjectDetails> projectDetails= projectDetailsRepo.findProjectDetailsByProject_Id(id);
       if(projectDetails.isPresent()){
           LOGGER.info("Data found sending it to controller");
           return projectDetails.get();
       }
       else{
           LOGGER.error("Project details by Project id:"+id+" not found");
           throw new RecordNotFound("Project with id " + id +" not found");
       }
    }
    public List<ProjectDetails> getProjectDetailsByChannelName(String name){
        LOGGER.info("Fetching all the details from the Repository with channel Name"+name);
        return projectDetailsRepo.findProjectDetailsByChannel_ChannelNameContainsIgnoreCase(name);
    }
}
