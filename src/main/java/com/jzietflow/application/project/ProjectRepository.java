package com.jzietflow.application.project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.jzietflow.domain.Project;

public interface ProjectRepository {
    Project save(Project project);

    Optional<Project> findById(UUID id);

    List<Project> findAll();
    
    void delete(UUID id);

    void update(Project project);
}
