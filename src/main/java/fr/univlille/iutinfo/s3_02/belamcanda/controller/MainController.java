package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainController {
    private static final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
    @FXML private ToolBarController toolBarController;
    @FXML private PointInfoController pointInfoController;
    @FXML private ScatterChartController scatterChartController;
    @FXML private AxisChoiceBoxController axisChoiceBoxController;
    @FXML private CategorizerSettingsController categorizerSettingsController;
    @FXML private DataToClassifyController dataToClassifyController;
    private MVCModel model;

    @FXML
    private void initialize() throws IOException {
        model = new CSVLoader().createModelFromFile(DATAPATH + "pokemon_train.csv");
        model.addDataToClassify(DATAPATH + "pokemon_test.csv");
        initializeControllers();
        updateModel();
    }

    private void initializeControllers() {
        dataToClassifyController.injectMainController(this);
        scatterChartController.injectMainController(this);
        toolBarController.injectMainController(this);
    }

    public void updateModel() {
        dataToClassifyController.updateTrainingData();
        categorizerSettingsController.createTableView(model.getNormalizableColumns());
        categorizerSettingsController.createCategorizer(getModel());
        axisChoiceBoxController.initChoiceBoxes(this);
        updateChartAxis();
    }

    public void updateChartAxis() {
        scatterChartController.updateChart();
    }

    public void setPointDescription(Point point) {
        pointInfoController.setPointDescription(point, model.getColumns());
    }

    public MVCModel getModel() {
        return model;
    }

    public void updateRobustness() {
        double robustness = categorizerSettingsController.getRobustness();
        double crossValidation = categorizerSettingsController.getCrossValidation();
        dataToClassifyController.updateRobustness(robustness, crossValidation);
    }

    public void setNewModel(MVCModel model) {
        this.model = model;
        updateModel();
    }

    public Column getXColSelected() {
        return axisChoiceBoxController.getXCol();
    }

    public Column getYColSelected() {
        return axisChoiceBoxController.getYCol();
    }

    public void addDataToClassify(String path) throws IOException {
        List<Point> pointsAdded = model.addDataToClassify(path);
        scatterChartController.addDataToClassify(pointsAdded);
        dataToClassifyController.updateTrainingData();
    }

    public void addDataToClassify(Point newPoint) {
        model.addDataToClassify(newPoint);
        scatterChartController.addDataToClassify(List.of(newPoint));
        dataToClassifyController.updateTrainingData();
    }
}
