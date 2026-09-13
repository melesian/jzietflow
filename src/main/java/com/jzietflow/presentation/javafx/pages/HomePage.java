package com.jzietflow.presentation.javafx.pages;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

// VBox can be extended...
public class HomePage extends VBox{
    HomePage(){
        Label pageTitle = new Label("Home");
        Label message = new Label("Your WorkStation");

        this.getChildren().add(pageTitle);
        this.getChildren().add(message);
    }
}
