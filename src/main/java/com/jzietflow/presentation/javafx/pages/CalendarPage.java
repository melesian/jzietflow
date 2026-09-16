package com.jzietflow.presentation.javafx.pages;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// VBox can be extended...
public class CalendarPage extends VBox{
    private YearMonth displayedMonth;
    private final Label monthLabel = new Label();
    private final GridPane calendarGrid = new GridPane();

    public CalendarPage(){
        displayedMonth = YearMonth.now();
        getStyleClass().add("calendar-page");

        setSpacing(15);

        Label pageTitle = new Label("Calendar");
        pageTitle.getStyleClass().add("calendar-title");

        Button previousButton = new Button("<");
        Button todayButton = new Button("Today");
        Button nextButton = new Button(">");

        HBox controls = new HBox(10);
        controls.getStyleClass().add("calendar-controls");
        controls.setAlignment(Pos.CENTER);

        controls.getChildren().add(previousButton);
        controls.getChildren().add(monthLabel);
        controls.getChildren().add(todayButton);
        controls.getChildren().add(nextButton);

        calendarGrid.setHgap(5);
        calendarGrid.setVgap(5);
        calendarGrid.setAlignment(Pos.TOP_CENTER);
        calendarGrid.getStyleClass().add("calendar-grid");


        previousButton.setOnAction((event) -> {
            displayedMonth = displayedMonth.minusMonths(1);
            renderCalendar();
        });

        todayButton.setOnAction((event) -> {
            displayedMonth = YearMonth.now();

            renderCalendar();
        });

        nextButton.setOnAction((event) -> {
            displayedMonth = displayedMonth.minusMonths(1);
            renderCalendar();
        });

        this.getChildren().add(pageTitle);
        this.getChildren().add(controls);
        this.getChildren().add(calendarGrid);

        renderCalendar();
    }

    private  void renderCalendar(){
        calendarGrid.getChildren().clear();

        updateMonthLabel();

        addDayHeaders();

        LocalDate firstDayOfMonth = displayedMonth.atDay(1);

        int startingColumn = firstDayOfMonth.getDayOfWeek().getValue() - 1;
        int daysInMonth = displayedMonth.lengthOfMonth();

        for(int day = 1; day <= daysInMonth; day++)
        {
            VBox cell = new VBox();
            cell.setAlignment(Pos.CENTER);
            cell.getStyleClass().add("calendar-cell");

            int position = startingColumn + day - 1;

            int column = position % 7;
            int row = position / 7 + 1;

            LocalDate date = displayedMonth.atDay(day);

            Label dayLabel = createDayLabel(date);
            dayLabel.getStyleClass().add("calendar-day");
            cell.getChildren().add(dayLabel);


            calendarGrid.add(cell, column, row);
        }
    }

    private void updateMonthLabel()
    {
        String monthName = displayedMonth.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        monthLabel.setText(monthName + " " + displayedMonth.getYear());
    }

    private void addDayHeaders(){
        for(DayOfWeek dayOfWeek : DayOfWeek.values())
        {
            String name = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);

            Label header = new Label(name);

            header.setMinWidth(100);
            header.setAlignment(Pos.CENTER);

            calendarGrid.add(header, dayOfWeek.getValue() - 1, 0);
        }
    }

    private Label createDayLabel(LocalDate date){
        Label label = new Label(String.valueOf(date.getDayOfMonth()));

        if(date.equals(LocalDate.now()))
        {
            label.setStyle("-fx-border-color: black;" + "-fx-border-width: 2;");
        }

        return label;
    }
}
