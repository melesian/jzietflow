package com.jzietflow.presentation.javafx.pages;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

// VBox can be extended...
public class ContentPage extends VBox{
    public ContentPage(){
        Label pageTitle = new Label("Content");
        Label message = new Label("Schedule Content");

        this.getChildren().add(pageTitle);
        this.getChildren().add(message);
    }
}
