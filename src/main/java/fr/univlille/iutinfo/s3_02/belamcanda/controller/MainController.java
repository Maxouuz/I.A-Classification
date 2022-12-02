package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.NormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.Distance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;

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
        initializeControllers();
        updateModel();
        setTestData(DATAPATH + "pokemon_test.csv");
    }

    private void initializeControllers() {
        dataToClassifyController.injectMainController(this);
        scatterChartController.injectMainController(this);
        toolBarController.injectMainController(this);
    }

    public void updateModel() {
        dataToClassifyController.updateDataToClassify();
        categorizerSettingsController.initCategorizerSettings(this);
        axisChoiceBoxController.initChoiceBoxes(this);
        toolBarController.computeRobustness();
        updateChartAxis();
    }

    public void updateChartAxis() {
        scatterChartController.updateChart();
        scatterChartController.addPointToClassify(model.getDataToClassify());
    }

    public void setPointDescription(Point point) {
        pointInfoController.setPointDescription(point, model.getColumns());
    }

    public MVCModel getModel() {
        return model;
    }

    public void updateRobustness() {
        double robustness = categorizerSettingsController.getRobustness();
        categorizerSettingsController.updateRobustness(robustness);
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

    public void setTestData(String path) throws IOException {
        model.setTestData(path);
        categorizerSettingsController.setTestDataFileName(new File(path).getName());
    }

    public void addPointToClassify(Point newPoint) {
        model.addPointToClassify(newPoint);
        scatterChartController.addPointToClassify(newPoint);
        dataToClassifyController.updateDataToClassify();
    }

    public void classify() {
        model.classify();
        dataToClassifyController.refreshTableView();
    }

    public void setDistanceMethod(Distance selected) {
        categorizerSettingsController.setDistanceMethod(selected);
    }

    public NormalizableColumn defaultXCol() {
        return model.defaultXCol();
    }

    public Column defaultYCol() {
        return model.defaultYCol();
    }
}
