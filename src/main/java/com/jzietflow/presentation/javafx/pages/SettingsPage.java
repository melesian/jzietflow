package com.jzietflow.presentation.javafx.pages;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

// VBox can be extended...
public class SettingsPage extends VBox{
    public SettingsPage(){
        Label pageTitle = new Label("Settings");
        Label message = new Label("Your Configs");

        this.getChildren().add(pageTitle);
        this.getChildren().add(message);
    }
}
