package com.jzietflow.application.project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public void deleteProject(UUID id){
        projectRepository.delete(id);
    }

    public void renameProject(UUID id, String name)
    {
        Optional<Project> project = projectRepository.findById(id);

        if(project.isEmpty())
        {
            throw new IllegalArgumentException("Project not found: " + id.toString());
        }

        project.get().rename(name);

        projectRepository.update(project.get());
    }
}
