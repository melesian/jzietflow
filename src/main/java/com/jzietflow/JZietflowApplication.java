package com.jzietflow;

import com.jzietflow.application.config.ApplicationConfig;
import com.jzietflow.application.project.ProjectService;
import com.jzietflow.presentation.javafx.shell.ApplicationShell;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * JZietflowApplication -   the entry class that extends the foundational class
 *                          which my entire App rests upon
 */
public class JZietflowApplication extends Application {
    private final ProjectService projectService = new ProjectService();
    public static void main(String[] args){
        launch();
    }

    @Override // needs to override the Application.start() method
    public void start(Stage stage){
        ApplicationConfig config = new ApplicationConfig();

        // DIMENSION STAGE
        stage.setWidth(config.WINDOW_WIDTH);
        stage.setHeight(config.WINDOW_HEIGHT);
        
        // STAGE -> more like a house
        // SCENE -> more like a room of a house where components live

        // to set title of current window
        stage.setTitle(config.NAME);


        ApplicationShell shell = new ApplicationShell(stage, config, projectService);
    }
}
