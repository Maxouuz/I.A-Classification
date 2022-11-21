package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicLoader;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;

public class MainController {
    @FXML private Font x3;
    @FXML private Color x4;
    @FXML private ChoiceBox<Column> xColCB;
    @FXML private ChoiceBox<Column> yColCB;
    @FXML private PointInfoController pointInfoTabController;
    @FXML private ScatterChartController scatterChartController;
    MVCModel model;
    private static final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;

    @FXML
    private void initialize() throws IOException {
        model = new TitanicLoader().createModelFromFile(DATA_PATH + "titanic.csv");
        setChoiceBox(xColCB, model.defaultXCol());
        setChoiceBox(yColCB, model.defaultYCol());
        scatterChartController.injectMainController(this);
        updateChartAxis();
    }

    private void setChoiceBox(ChoiceBox<Column> choiceBox, Column defaultCol) {
        choiceBox.getItems().addAll(model.getColumns());
        choiceBox.getSelectionModel().select(defaultCol);
        choiceBox.setOnAction(e -> updateChartAxis());
    }

    private void updateChartAxis() {
        Column xCol = xColCB.getSelectionModel().getSelectedItem();
        Column yCol = yColCB.getSelectionModel().getSelectedItem();
        scatterChartController.setAxis(xCol, yCol);
    }

    public void setPointDescription(Point point) {
        pointInfoTabController.setPointDescription(point, model.getColumns());
    }

    public MVCModel getModel() {
        return model;
    }
}
