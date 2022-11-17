package fr.univlille.iutinfo.s3_02.belamcanda.view;


import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import javafx.scene.chart.*;

import java.util.HashSet;
import java.util.Set;

public class TheCloud {
    public ScatterChart scatterChart(MVCModel model, Column xCol, Column yCol){
        var scatterChart = new ScatterChart(getAxis(xCol), getAxis(yCol));
        scatterChart.getData().addAll(getAllSeries(model, xCol, yCol));
        return scatterChart;
    }

    private static Set<XYChart.Series<String, Number>> getAllSeries(MVCModel model, Column xCol, Column yCol) {
        Set<XYChart.Series<String, Number>> series = new HashSet<>();
        for (Category category: model.allCategories()) {
            series.add(getSeries(category, xCol, yCol));
        }
        return series;
    }

    public ScatterChart scatterChart(MVCModel model) {
        return scatterChart(model, model.defaultXCol(), model.defaultYCol());
    }

    private static XYChart.Series getSeries(IDataset dataset, Column xCol, Column yCol) {
        var data = new XYChart.Series();
        for (Point point : dataset) {
            data.getData().add(getData(point, xCol, yCol));
        }
        return data;
    }

    private Axis getAxis(Column col) {
        if (col.isNumeric()) return getNumberAxis((NumberColumn) col);
        return getStringAxis(col);
    }

    private static XYChart.Data getData(Point point, Column xCol, Column yCol){
        var x = xCol.isNumeric() ? point.getValue(xCol) : point.getStringValue(xCol);
        var y = yCol.isNumeric() ? point.getValue(yCol): point.getStringValue(yCol);
        return new XYChart.Data<>(x, y);
    }


    private NumberAxis getNumberAxis(NumberColumn col) {
        String name = col.getName();
        int min = (int) Math.floor(col.min());
        int max = (int) Math.ceil(col.max());
        int tick = (max - min) / 10;
        return new NumberAxis(name, min, max, tick);
    }

    private CategoryAxis getStringAxis(Column col){
        String name = col.getName();
        CategoryAxis res = new CategoryAxis();
        res.setLabel(name);
        return res;
    }


}
