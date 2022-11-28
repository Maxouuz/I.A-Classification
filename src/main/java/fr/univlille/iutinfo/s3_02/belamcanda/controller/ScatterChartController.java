package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class ScatterChartController {
    private MainController mainController;
    @FXML private VBox scatterChart;
    @FXML private ScatterChart<?, ?> chart;

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void updateChart() {
        Column xCol = mainController.getXColSelected();
        Column yCol = mainController.getYColSelected();
        chart = new ModelScatterChart<>(getAxis(xCol), getAxis(yCol), mainController);
        scatterChart.getChildren().set(0, chart);
    }

    public void addDataToClassify(Collection<Point> dataToClassify) {
        ((ModelScatterChart<?, ?>) chart).addDataToClassify(dataToClassify);
    }

    private Axis<?> getAxis(Column col) {
        Axis<?> res;
        if (col.isNumeric()) res = new NumberAxis();
        else res = new CategoryAxis();
        res.setLabel(col.getName());
        return res;
    }
}
