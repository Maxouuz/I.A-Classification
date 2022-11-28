package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;

public class ScatterChartController {
    MainController mainController;
    Column xCol, yCol;
    @FXML private VBox scatterChart;
    @FXML private ScatterChart<?, ?> chart;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void updateChart() {
        this.xCol = mainController.getXColSelected();
        this.yCol = mainController.getYColSelected();
        chart = new ModelScatterChart<>(getAxis(xCol), getAxis(yCol), mainController);
        scatterChart.getChildren().set(0, chart);
    }

    private Axis<?> getAxis(Column col) {
        Axis<?> res;
        if (col.isNumeric()) res = new NumberAxis();
        else res = new CategoryAxis();
        res.setLabel(col.getName());
        return res;
    }
}
