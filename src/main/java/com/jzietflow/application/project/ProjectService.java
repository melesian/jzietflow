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

    public Project createProject(String projectName, String projectDescription)
    {
        Project project = new Project(projectName, projectDescription);

        return projectRepository.save(project);
    }
    
    public List<Project> getProjects()
    {
        return projectRepository.findAll();
    }

    public void deleteProject(UUID id){
        projectRepository.delete(id);
    }

    public void updateProject(UUID id, String name, String description)
    {
        Optional<Project> project = projectRepository.findById(id);

        if(project.isEmpty())
        {
            throw new IllegalArgumentException("Project not found: " + id.toString());
        }

        Project existingProject = project.get();

        existingProject.rename(name);
        existingProject.updateDescription(description);

        projectRepository.update(existingProject);
    }
}
