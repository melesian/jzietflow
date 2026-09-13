package com.jzietflow.presentation.javafx.shell;

import com.jzietflow.application.config.ApplicationConfig;
import com.jzietflow.application.project.ProjectService;
import com.jzietflow.presentation.javafx.navigation.Page;
import com.jzietflow.presentation.javafx.pages.ContentPage;
import com.jzietflow.presentation.javafx.pages.CalendarPage;
import com.jzietflow.presentation.javafx.pages.HomePage;
import com.jzietflow.presentation.javafx.pages.ProjectsPage;
import com.jzietflow.presentation.javafx.pages.SettingsPage;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ApplicationShell {
    private Page currentPage;
    private ApplicationConfig config;

    private final HomePage homePage = new HomePage();
    private final ProjectsPage projectsPage = new ProjectsPage();
    private final ContentPage contentPage = new ContentPage();
    private final SettingsPage settingsPage = new SettingsPage();
    private final CalendarPage calendarPage = new CalendarPage();

    private  final ProjectService projectService;

    private BorderPane root = new BorderPane();

    public ApplicationShell(
        Stage stage, 
        ApplicationConfig config,
        ProjectService projectService)
        {
        // set the current page
        currentPage = Page.HOME;
        this.config = config;
        this.projectService = projectService;

        // creating layout -> using BorderPane
        // BorderPane root = new BorderPane();

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
        homeButton.setOnAction(event -> navigateTo(Page.HOME));
        calendarButton.setOnAction(event -> navigateTo(Page.CALENDAR));
        projectsButton.setOnAction(event -> navigateTo(Page.PROJECTS));
        contentButton.setOnAction(event -> navigateTo(Page.CONTENT));
        settingsButton.setOnAction(event -> navigateTo(Page.SETTINGS));


        // to show current window
        stage.show();
    }

    public Page getCurrentPage(){
        return currentPage;
    }

    private void showPage(Node page)
    {
        root.setCenter(page);
    }

    public void navigateTo(Page page)
    {
        if(page.equals(currentPage)) return; 
        
        switch(page){
            case HOME :
                currentPage = page;
                showPage(homePage);
                break;
            case CONTENT :
                currentPage = page;
                showPage(contentPage);
                break;
            case CALENDAR :
                currentPage = page;
                showPage(calendarPage);
                break;
            case PROJECTS :
                currentPage = page;
                showPage(projectsPage);
                break;
            case SETTINGS :
                currentPage = page;
                showPage(settingsPage);
                break;
        }
    }
}
