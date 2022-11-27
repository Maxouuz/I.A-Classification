package fr.univlille.iutinfo.s3_02.belamcanda.controller;


import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
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
    Column xCol, yCol;
    Boolean xNum, yNum;
    XYChart.Series aClassifier;
    @FXML private VBox scatterChart;
    @FXML private ScatterChart chart;

    private Set<XYChart.Series> allSeries(MVCModel model) {
        Set<XYChart.Series> res = new HashSet<>();
        for (Category category: model.allCategories()) {
            res.add(series(category, category.getTitle()));
        }
        return res;
    }

    private XYChart.Series series(Iterable<Point> dataset, String title) {
        var res = new XYChart.Series();
        res.nameProperty().setValue(title);
        for (Point point : dataset) {
            res.getData().add(dataPoint(point));
        }
        return res;
    }

    private Axis getAxis(Column col) {
        Axis res;
        if (col.isNumeric()) res = new NumberAxis();
        else res = new CategoryAxis();
        res.setLabel(col.getName());
        return res;
    }

    private XYChart.Data dataPoint(Point point){
        var x = xNum ? point.getValue(xCol) : point.getStringValue(xCol);
        var y = yNum ? point.getValue(yCol): point.getStringValue(yCol);
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

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void updateChart(Column xCol, Column yCol) {
        this.xCol = xCol;
        this.xNum = xCol.isNumeric();
        this.yCol = yCol;
        this.yNum = yCol.isNumeric();
        this.aClassifier = series(mainController.getModel().getDataToClassify(), "A classifier");
        chart = newChart();
        scatterChart.getChildren().set(0, chart);
    }

    public void addToClassify(Point p){
        aClassifier.getData().add(dataPoint(p));
    }

    private ScatterChart newChart(){
        var res = new ScatterChart(getAxis(xCol), getAxis(yCol));
        MVCModel model = mainController.getModel();
        res.getData().addAll(allSeries(model));
        res.getData().add(aClassifier);
        res.setTitle(model.getTitle());
        VBox.setVgrow(res, Priority.ALWAYS);
        return res;
    }
}
