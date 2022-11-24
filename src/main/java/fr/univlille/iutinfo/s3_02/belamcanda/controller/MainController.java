package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonLoader;
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
    @FXML private DataToClassifyController dataToClassifyController;
    private MVCModel model;

    @FXML
    private void initialize() throws IOException {
        model = new PokemonLoader().createModelFromFile(DATA_PATH + "pokemon_train.csv");
        initializeControllers();
        dataToClassifyController.addTrainingData(new PokemonLoader().loadFromFile(DATA_PATH + "pokemon_test.csv"));
        updateChartAxis();
    }

    private void initializeControllers() {
        dataToClassifyController.injectMainController(this);
        scatterChartController.injectMainController(this);
        toolBarController.injectMainController(this);
        axisChoiceBoxController.initChoiceBoxes(this);
        categorizerSettingsController.createTableView(model.getColumns());
        categorizerSettingsController.createCategorizer(getModel());
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

    public double getRobustness() {
        return categorizerSettingsController.getRobustness();
    }

    public void updateRobustness(double robustness) {
        dataToClassifyController.updateRobustness(robustness);
    }
}
