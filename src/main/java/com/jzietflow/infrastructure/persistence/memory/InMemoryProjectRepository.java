package com.jzietflow.infrastructure.persistence.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jzietflow.application.project.ProjectRepository;
import com.jzietflow.domain.Project;

public class InMemoryProjectRepository implements ProjectRepository {
    private final List<Project> projects = new ArrayList<>();

    @Override 
    public Project save(Project project){
        projects.add(project);

        return project;
    }

    @Override 
    public void delete(UUID id){
        projects.removeIf((project) -> project.getId().equals(id));
    }

    @Override 
    public List<Project> findAll(){
        return List.copyOf(projects);
    }

    @Override 
    public Optional<Project> findById(UUID id){
        // for(Project project : projects)
        // {
        //     if(project.getId().equals(id))
        //     {
        //         return Optional.of(project);
        //     }
        // }

        // return Optional.empty();

        return projects.stream().filter((project) -> project.getId().equals(id)).findFirst();
    }

    @Override 
    public void update(Project project){

    }
}
