package com.jzietflow;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
        
        // STAGE -> more like a house
        // SCENE -> more like a room of a house where components live

        // to set title of current window
        stage.setTitle("jZietflow");


        // creating a label
        Label label = new Label("Your Personal Workstation");

        // create a scene and add a label into it
        Scene scene = new Scene(label);

        // add a scene into a stage
        stage.setScene(scene);

        // to show current window
        stage.show();
    }
}
