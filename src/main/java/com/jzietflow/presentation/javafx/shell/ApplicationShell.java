package com.jzietflow.presentation.javafx.shell;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApplicationShell {
    public ApplicationShell(Stage stage){
        // creating layout -> using BorderPane
        BorderPane root = new BorderPane();

        // creating nav bar -> using VBox (It stacks nodes vertically)
        VBox navigation = new VBox();

        // creating buttons for all pages
        Button homeButton       = new Button("Home");
        Button calendarButton   = new Button("Calendar");
        Button projectsButton   = new Button("Projects");
        Button contentButton    = new Button("Content");
        Button settingsButton   = new Button("Settings");

        // to add into a box -> using getChildren().add() method
        navigation.getChildren().add(homeButton);
        navigation.getChildren().add(calendarButton);
        navigation.getChildren().add(projectsButton);
        navigation.getChildren().add(contentButton);
        navigation.getChildren().add(settingsButton);

        // some spacing around the children
        navigation.setSpacing(10);

        // add to the left of the layout
        root.setLeft(navigation);

        // creating a label
        Label pageTitle = new Label("Home");

        // add to the center of the layout
        root.setCenter(pageTitle);

        // create a scene and add a label into it
        Scene scene = new Scene(root);

        // add a scene into a stage
        stage.setScene(scene);



        // adding a eventHandler on a button
        // passing a callback function (not really, just a lambda expression)
        homeButton.setOnAction(event -> pageTitle.setText("Home Page"));
        calendarButton.setOnAction(event -> pageTitle.setText("Calendar Management"));
        projectsButton.setOnAction(event -> pageTitle.setText("Project Management"));
        contentButton.setOnAction(event -> pageTitle.setText("Content Management"));
        settingsButton.setOnAction(event -> pageTitle.setText("Settings"));


        // to show current window
        stage.show();
    }
    private void showPage(){
        
    }
}
