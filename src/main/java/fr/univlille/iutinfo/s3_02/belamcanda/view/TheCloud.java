package fr.univlille.iutinfo.s3_02.belamcanda.view;


import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

public class TheCloud {
    MainController thomas;

    public TheCloud(MainController thomas){this.thomas = thomas;}

    public ScatterChart scatterChart(MVCModel model, Column xCol, Column yCol){
        var scatterChart = new ScatterChart(getAxis(xCol), getAxis(yCol));
        scatterChart.getData().addAll(getAllSeries(model, xCol, yCol));
        scatterChart.setTitle(model.getTitle());
        return scatterChart;
    }

    private Set<XYChart.Series> getAllSeries(MVCModel model, Column xCol, Column yCol) {
        Set<XYChart.Series> series = new HashSet<>();
        for (Category category: model.allCategories()) {
            series.add(getSeries(category, xCol, yCol));
        }
        return series;
    }

    public ScatterChart scatterChart(MVCModel model) {
        return scatterChart(model, model.defaultXCol(), model.defaultYCol());
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
        res.setNode(button(thomas, point));
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


}
