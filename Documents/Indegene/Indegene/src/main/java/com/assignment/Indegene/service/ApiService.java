package com.assignment.Indegene.service;

import com.assignment.Indegene.entity.Project;
import com.assignment.Indegene.entity.ProjectDetails;

import java.util.List;

public interface ApiService {
    public List<ProjectDetails> getAllProjectDetails();
    public ProjectDetails saveProjectDetails(ProjectDetails projectDetails);
    public Project getProjectById(Long id);
    public List<Project> getAllProjects();
    public ProjectDetails getProjectDetailsById(long id);
    public List<ProjectDetails> getProjectDetailsByChannelName(String name);
}
