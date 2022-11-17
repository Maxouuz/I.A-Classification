package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class pourMonsieurClavierPetitCoeur extends Application {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
    ScatterChart scatterChart;
    VBox scatterBox = new VBox();
    VBox root;

    MVCModel model = new PokemonLoader().createModelFromFile(DATA_PATH + "pokemon_train.csv");

    public pourMonsieurClavierPetitCoeur() throws IOException {
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


        scatterChart = new TheCloud().scatterChart(model);
        scatterBox.getChildren().add(scatterChart);
        root = new VBox(scatterBox, axeX, axeY);



        Scene scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private void updateChart(Column x, Column y) {
        scatterBox.getChildren().remove(scatterChart);
        scatterChart = new TheCloud().scatterChart(model, x, y);
        scatterBox.getChildren().add(scatterChart);
    }


    public static void main(String[] args) {
        launch();
    }

}
