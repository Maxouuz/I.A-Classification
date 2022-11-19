package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

import java.util.Arrays;

public class ScatterChartArea extends MVCViewArea {
    ComboBox<Column> xColCB;
    ComboBox<Column> yColCB;


    ScatterChart chart;
    Column yCol;
    Column xCol;

    public ScatterChartArea(MVCView parent) {
        super(parent);
        setXCol(model.defaultXCol());
        setYCol(model.defaultYCol());
        setComboBoxes();
        updateChart();
    }

    private void setComboBoxes() {
        ObservableList<Column> columns = FXCollections.observableList(Arrays.asList(model.getColumns()));
        xColCB = comboBox(columns, model.defaultXCol());
        yColCB = comboBox(columns, model.defaultYCol());
        getChildren().add(new HBox(xColCB, yColCB));
    }

    private ComboBox<Column> comboBox(ObservableList<Column> columns, Column col) {
        ComboBox<Column> res = new ComboBox<>(columns);
        res.getSelectionModel().select(col);
        res.setOnAction(e -> updateAxis());
        return res;
    }

    private void updateAxis() {
        setXCol(xColCB.getValue());
        setYCol(yColCB.getValue());
        updateChart();
    }

    public void setXCol(Column col) {
        this.xCol = col;
    }

    public void setYCol(Column col) {
        this.yCol = col;
    }


    private void updateChart() {
        System.out.println(String.format("X: %s; \tY: %s", xCol.getName(), yCol.getName()));
        if (getChildren().contains(chart)) getChildren().remove(chart);
        this.chart = new TheCloud(parent).scatterChart(model, xCol, yCol);
        getChildren().add(chart);
    }
}
