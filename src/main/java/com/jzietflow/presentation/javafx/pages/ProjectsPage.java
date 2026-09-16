package com.jzietflow.presentation.javafx.pages;

import java.util.List;

import com.jzietflow.application.project.ProjectService;
import com.jzietflow.domain.Project;
import com.jzietflow.domain.ProjectStatus;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextArea;


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
        TextArea projectDescription = new TextArea("Project description");
        Button projectCreateButton = new Button("Create Project");
        

        projectForm.getChildren().add(projectLabel);
        projectForm.getChildren().add(projectName);
        projectForm.getChildren().add(projectDescription);
        projectForm.getChildren().add(projectCreateButton);

        projectCreateButton.setOnAction((event) -> {
            String name = projectName.getText();
            String description = projectDescription.getText();

            Project project = projectService.createProject(name, description);

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
            HBox projectRow = new HBox(5);
            Label projectLabel = new Label(project.getName());
            Label projectDescription = new Label(project.getDescription());
            Label projectStatus = new Label(project.getStatus().name());

            Button editButton = new Button("Edit");
            Button deleteButton = new Button("Delete");

            editButton.setOnAction((event) -> {
                TextField editName = new TextField(project.getName());
                TextArea editDescription = new TextArea(project.getDescription());
                ComboBox<ProjectStatus> statusBox = new ComboBox<>();


                statusBox.getItems().addAll(ProjectStatus.values());
                statusBox.setValue(project.getStatus());

                Button saveButton = new Button("Save");
                Button cancelButton = new Button("Cancel");

                projectRow.getChildren().clear();

                projectRow.getChildren().add(editName);
                projectRow.getChildren().add(editDescription);
                projectRow.getChildren().add(statusBox);
                projectRow.getChildren().add(saveButton);
                projectRow.getChildren().add(cancelButton);

                saveButton.setOnAction((saveEvent) -> {
                    String newName = editName.getText();
                    String newDescription = editDescription.getText();
                    ProjectStatus newStatus = statusBox.getValue();

                    if(newName.isBlank() || newDescription.isBlank()) return;

                    projectService.updateProject(project.getId(), newName, newDescription, newStatus);

                    loadProjects();
                });

                cancelButton.setOnAction((cancelEvent) -> {
                    loadProjects();
                });
            });

            deleteButton.setOnAction((event) -> {
                projectService.deleteProject(project.getId());
                loadProjects();
            });

            projectRow.getChildren().add(projectLabel);
            projectRow.getChildren().add(projectDescription);
            projectRow.getChildren().add(projectStatus);
            projectRow.getChildren().add(editButton);
            projectRow.getChildren().add(deleteButton);

            projectList.getChildren().add(projectRow);
        }
    }
}
