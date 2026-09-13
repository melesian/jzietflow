package com.jzietflow.presentation.javafx.pages;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

// VBox can be extended...
public class CalendarPage extends VBox{
    CalendarPage(){
        Label pageTitle = new Label("Calendar");
        Label message = new Label("Your Monthly Plan");

        this.getChildren().add(pageTitle);
        this.getChildren().add(message);
    }
}
