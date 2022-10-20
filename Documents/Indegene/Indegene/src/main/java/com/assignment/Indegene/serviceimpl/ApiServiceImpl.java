package com.assignment.Indegene.serviceimpl;

import com.assignment.Indegene.entity.Project;
import com.assignment.Indegene.entity.ProjectDetails;
import com.assignment.Indegene.exceptions.RecordNotFound;
import com.assignment.Indegene.repository.ProjectDetailsRepository;
import com.assignment.Indegene.repository.ProjectRepository;
import com.assignment.Indegene.service.ApiService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private ProjectDetailsRepository projectDetailsRepo;
    private ProjectRepository projectRepository;
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
        return projectRepository.findById(id).orElseThrow(()-> new RecordNotFound("Project with id "+id+" not found"));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public ProjectDetails getProjectDetailsById(long id) {
        return projectDetailsRepo.getProjectDetailsById(id).orElseThrow(()->new RecordNotFound("Project with id " + id +" not found"));
    }
}
