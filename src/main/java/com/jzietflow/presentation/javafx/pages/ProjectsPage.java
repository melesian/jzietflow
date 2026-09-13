package com.jzietflow.presentation.javafx.pages;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

// VBox can be extended...
public class ProjectsPage extends VBox{
    public ProjectsPage(){
        Label pageTitle = new Label("Projects");
        Label message = new Label("Your Work");

        this.getChildren().add(pageTitle);
        this.getChildren().add(message);
    }
}
