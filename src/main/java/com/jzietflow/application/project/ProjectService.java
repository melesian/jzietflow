package com.jzietflow.application.project;

import com.jzietflow.domain.Project;

public class ProjectService {
    public Project createProject(String projectName){
        
        Project project = new Project(projectName);

        return project;
    }
}
