package com.jzietflow.presentation.javafx.pages;

import java.util.List;

import com.jzietflow.application.project.ProjectService;
import com.jzietflow.domain.Project;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

// VBox can be extended...
public class ProjectsPage extends VBox{
    private final ProjectService projectService;
    private final VBox projectList = new VBox(10);


    public ProjectsPage(ProjectService projectService){
        this.projectService = projectService;

        Label pageTitle = new Label("Projects");
        Label message = new Label("Your Work");

        this.getChildren().add(pageTitle);
        this.getChildren().add(message);

        // PROJECT FORM
        VBox projectForm = new VBox();

        Label projectLabel = new Label("Add a project");
        TextField projectName = new TextField("Project name here");
        Button projectCreateButton = new Button("Create Project");

        projectForm.getChildren().add(projectLabel);
        projectForm.getChildren().add(projectName);
        projectForm.getChildren().add(projectCreateButton);

        projectCreateButton.setOnAction((event) -> {
            String name = projectName.getText();

            Project project = projectService.createProject(name);

            if(project != null){
                message.setText("Project created: " + project.getId());
            }

            loadProjects();
        });

        this.getChildren().add(projectForm);

        loadProjects();
        this.getChildren().add(projectList);
    }

    private void loadProjects()
    {
        List<Project> projects = projectService.getProjects();

        projectList.getChildren().clear();

        for(Project project : projects)
        {
            Label projectLabel = new Label(project.getName());

            projectList.getChildren().add(projectLabel);
        }
    }
}
