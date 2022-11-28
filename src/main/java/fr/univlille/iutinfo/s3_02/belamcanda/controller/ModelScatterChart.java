package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Category;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

public class ModelScatterChart<X,Y> extends ScatterChart<X,Y> {
    private final MainController mainController;

    public ModelScatterChart(Axis<X> xAxis, Axis<Y> yAxis, MainController mainController) {
        super(xAxis, yAxis);
        this.mainController = mainController;
        createChart();
    }

    private Set<Series<X,Y>> allSeries(MVCModel model) {
        Set<XYChart.Series<X,Y>> res = new HashSet<>();
        for (Category category: model.allCategories()) {
            res.add(series(category, category.getTitle()));
        }
        return res;
    }

    private XYChart.Series<X,Y> series(Iterable<Point> dataset, String title) {
        XYChart.Series<X,Y> res = new XYChart.Series<>();
        res.nameProperty().setValue(title);
        for (Point point : dataset) {
            res.getData().add(dataPoint(point));
        }
        return res;
    }

    private XYChart.Data<X,Y> dataPoint(Point point){
        Column xCol = mainController.getXColSelected();
        Column yCol = mainController.getYColSelected();
        X x = xCol.isNumeric() ? (X) point.getValue(xCol) : (X) point.getStringValue(xCol);
        Y y = yCol.isNumeric() ? (Y) point.getValue(yCol) : (Y) point.getStringValue(yCol);
        XYChart.Data<X,Y> res = new XYChart.Data<>(x, y);
        res.setNode(button(mainController, point));
        return res;
    }

    private XYChart.Series<X,Y> getSeriesOfDataToClassify() {
        return series(mainController.getModel().getDataToClassify(), "A classifier");
    }

    private void createChart(){
        MVCModel model = mainController.getModel();
        getData().addAll(allSeries(model));
        if (!model.getDataToClassify().isEmpty()) {
            getData().add(getSeriesOfDataToClassify());
        }
        setTitle(model.getTitle());
        VBox.setVgrow(this, Priority.ALWAYS);
    }

    private Button button(MainController mainController, Point point){
        Button bt = new Button();
        Tooltip tip = new Tooltip(point.category().toString());
        tip.setShowDelay(Duration.millis(75));
        Tooltip.install(bt, tip);
        bt.setOnAction(e -> mainController.setPointDescription(point));
        return bt;
    }
}
