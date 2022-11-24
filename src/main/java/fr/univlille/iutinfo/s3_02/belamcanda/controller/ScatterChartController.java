package fr.univlille.iutinfo.s3_02.belamcanda.controller;


import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

public class ScatterChartController {
    MainController mainController;
    @FXML private VBox scatterChart;
    @FXML private ScatterChart chart;

    private Set<XYChart.Series> getAllSeries(MVCModel model, Column xCol, Column yCol) {
        Set<XYChart.Series> series = new HashSet<>();
        for (Category category: model.allCategories()) {
            series.add(getSeries(category, xCol, yCol));
        }
        return series;
    }

    private XYChart.Series getSeries(IDataset dataset, Column xCol, Column yCol) {
        var data = new XYChart.Series();
        data.nameProperty().setValue(dataset.getTitle());
        for (Point point : dataset) {
            data.getData().add(getData(point, xCol, yCol));
        }
        return data;
    }

    private Axis getAxis(Column col) {
        if (col.isNumeric()) return getNumberAxis(col);
        return getStringAxis(col);
    }

    private XYChart.Data getData(Point point, Column xCol, Column yCol){
        var x = xCol.isNumeric() ? point.getValue(xCol) : point.getStringValue(xCol);
        var y = yCol.isNumeric() ? point.getValue(yCol): point.getStringValue(yCol);
        XYChart.Data res = new XYChart.Data<>(x, y);
        res.setNode(button(mainController, point));
        return res;
    }

    private Button button(MainController thomas, Point point){
        Button bt = new Button();
        Tooltip tip = new Tooltip(point.category().toString());
        tip.setShowDelay(Duration.millis(75));
        Tooltip.install(bt, tip);
        bt.setOnAction(e -> thomas.setPointDescription(point));
        return bt;
    }

    private NumberAxis getNumberAxis(Column col) {
        String name = col.getName();
        NumberAxis res = new NumberAxis();
        res.setLabel(name);
        return res;
    }

    private CategoryAxis getStringAxis(Column col){
        String name = col.getName();
        CategoryAxis res = new CategoryAxis();
        res.setLabel(name);
        return res;
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setAxis(Column xCol, Column yCol) {
        chart = new ScatterChart(getAxis(xCol), getAxis(yCol));
        MVCModel model = mainController.getModel();
        chart.getData().addAll(getAllSeries(model, xCol, yCol));
        chart.setTitle(model.getTitle());
        updateNewChart();
    }

    private void updateNewChart() {
        VBox.setVgrow(chart, Priority.ALWAYS);
        scatterChart.getChildren().set(0, chart);
    }
}
