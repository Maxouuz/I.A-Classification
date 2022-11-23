package fr.univlille.iutinfo.s3_02.belamcanda.view.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicLoader;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;

public class MainController {
    private static final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
    @FXML private ToolBarController toolBarController;
    @FXML private PointInfoController pointInfoController;
    @FXML private ScatterChartController scatterChartController;
    @FXML private AxisChoiceBoxController axisChoiceBoxController;
    @FXML private CategorizerSettingsController categorizerSettingsController;
    @FXML private TrainingDataController trainingDataController;
    private MVCModel model;

    @FXML
    private void initialize() throws IOException {
        model = new TitanicLoader().createModelFromFile(DATA_PATH + "titanic.csv");

        axisChoiceBoxController.initChoiceBoxes(this);
        scatterChartController.injectMainController(this);
        categorizerSettingsController.injectMainController(this);

        updateChartAxis();
    }

    public void updateChartAxis() {
        Column xCol = axisChoiceBoxController.getXCol();
        Column yCol = axisChoiceBoxController.getYCol();
        scatterChartController.setAxis(xCol, yCol);
    }

    public void setPointDescription(Point point) {
        pointInfoController.setPointDescription(point, model.getColumns());
    }

    public MVCModel getModel() {
        return model;
    }

    public int getK() {
        return categorizerSettingsController.getK();
    }
}
