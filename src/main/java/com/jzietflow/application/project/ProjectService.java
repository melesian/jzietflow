package com.jzietflow.application.project;

import java.util.List;

import com.jzietflow.domain.Project;

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }

    public Project createProject(String projectName)
    {
        Project project = new Project(projectName);

        return projectRepository.save(project);
    }
    
    public List<Project> getProjects()
    {
        return projectRepository.findAll();
    }
}
