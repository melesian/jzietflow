package com.jzietflow.application.project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jzietflow.domain.Project;
import com.jzietflow.domain.ProjectStatus;

public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }

    public Project createProject(String name, String description)
    {
        return createProject(name, description, ProjectStatus.PLANNED);
    }

    public Project createProject(String projectName, String projectDescription, ProjectStatus projectStatus)
    {
        Project project = new Project(projectName, projectDescription, projectStatus);

        return projectRepository.save(project);
    }

    public void changeProjectStatus(UUID id, ProjectStatus status){
        Optional<Project> project = projectRepository.findById(id);

        if(project.isEmpty()) throw new IllegalArgumentException("Project not found: " + id.toString());

        Project existingProject = project.get();

        existingProject.changeStatus(status);

        projectRepository.update(existingProject);
    }
    
    public List<Project> getProjects()
    {
        return projectRepository.findAll();
    }

    public void deleteProject(UUID id){
        projectRepository.delete(id);
    }

    public void updateProject(UUID id, String name, String description, ProjectStatus status)
    {
        Optional<Project> project = projectRepository.findById(id);

        if(project.isEmpty())
        {
            throw new IllegalArgumentException("Project not found: " + id.toString());
        }

        Project existingProject = project.get();

        existingProject.rename(name);
        existingProject.updateDescription(description);
        existingProject.changeStatus(status);

        projectRepository.update(existingProject);
    }
}
