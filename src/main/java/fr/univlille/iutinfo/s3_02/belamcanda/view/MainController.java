package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class MainController {
    @FXML
    Font x3;
    @FXML
    Color x4;
    @FXML
    ChoiceBox<Column> xColCB;
    @FXML
    ChoiceBox<Column> yColCB;
    @FXML
    VBox chartContainer;
    @FXML
    ScatterChart<?, ?> chart;
    @FXML
    Label pointTitle;
    @FXML
    Label pointDescription;

    MVCModel model;
    private static final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;

    @FXML
    public void initialize() throws IOException {
        model = new TitanicLoader().createModelFromFile(DATA_PATH + "titanic.csv");
        setChoiceBox(xColCB, model.defaultXCol());
        setChoiceBox(yColCB, model.defaultYCol());
        updateChartAxis();
    }

    private void setChoiceBox(ChoiceBox<Column> choiceBox, Column defaultCol) {
        choiceBox.getItems().addAll(model.getColumns());
        choiceBox.getSelectionModel().select(defaultCol);
        choiceBox.setOnAction(e -> updateChartAxis());
    }

    private void updateChartAxis() {
        Column xCol = xColCB.getSelectionModel().getSelectedItem();
        Column yCol = yColCB.getSelectionModel().getSelectedItem();
        this.chart = new TheCloud(this).scatterChart(model, xCol, yCol);
        VBox.setVgrow(chart, Priority.ALWAYS);
        chartContainer.getChildren().set(0, chart);
    }

    public void updatePointInfo(Point point) {
        String acc = "";
        for (Column column: model.getColumns()) {
            acc += column.getName() + ": " + point.getStringValue(column) + "\n";
        }
        pointDescription.setText(acc);
    }
}
