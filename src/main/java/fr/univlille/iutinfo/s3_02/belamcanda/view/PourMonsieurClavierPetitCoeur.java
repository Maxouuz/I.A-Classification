package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicLoader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class PourMonsieurClavierPetitCoeur extends Application {
    private static final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
    public static final int DEFAULT_WINDOW_WIDTH = 640;
    public static final int DEFAULT_WINDOW_HEIGHT = 480;
    private ScatterChart<?, ?> scatterChart;
    private VBox scatterBox = new VBox();
    private MVCModel model;

    public PourMonsieurClavierPetitCoeur() throws IOException {
        model = new TitanicLoader().createModelFromFile(DATA_PATH + "titanic.csv");
    }

    @Override
    public void start(Stage stage) {
        ComboBox<Column> axeX = new ComboBox<>();
        ComboBox<Column> axeY = new ComboBox<>();

        ObservableList<Column> columns = FXCollections.observableList(Arrays.asList(model.getColumns()));

        axeX.setItems(columns);
        axeX.getSelectionModel().select(model.defaultXCol());
        axeY.setItems(columns);
        axeY.getSelectionModel().select(model.defaultYCol());

        axeX.setOnAction(e -> updateChart(axeX.getValue(), axeY.getValue()));
        axeY.setOnAction(e -> updateChart(axeX.getValue(), axeY.getValue()));

        scatterChart = new TheCloud(this).scatterChart(model);
        scatterBox.getChildren().add(scatterChart);
        VBox root = new VBox(scatterBox, axeX, axeY);

        Scene scene = new Scene(root, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    private void updateChart(Column x, Column y) {
        scatterBox.getChildren().remove(scatterChart);
        scatterChart = new TheCloud(this).scatterChart(model, x, y);
        scatterBox.getChildren().add(scatterChart);
    }


    public static void main(String[] args) {
        launch();
    }

    public void updatePointInfo(Point point) {

    }
}
