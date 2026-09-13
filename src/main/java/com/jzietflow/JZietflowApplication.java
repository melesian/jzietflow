package com.jzietflow;

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
    public static void main(String[] args){
        launch();
    }

    @Override // needs to override the Application.start() method
    public void start(Stage stage){
        // DIMENSION STAGE
        stage.setWidth(1366);
        stage.setHeight(760);
        
        // STAGE -> more like a house
        // SCENE -> more like a room of a house where components live

        // to set title of current window
        stage.setTitle("jZietflow");


        ApplicationShell applicationShell = new ApplicationShell(stage);
        
    }
}
