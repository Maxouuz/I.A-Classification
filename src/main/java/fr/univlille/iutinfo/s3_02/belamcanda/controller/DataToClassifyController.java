package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.util.List;

public class DataToClassifyController {
    @FXML private ListView<Point> toClassify;
    @FXML private Label robustness;
    private MainController mainController;

    @FXML
    public void initialize() {
        toClassify.setOnMouseClicked(e -> updatePointDescription());
    }

    private void updatePointDescription() {
        mainController.setPointDescription(toClassify.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void addTrainingData(Point data) {
        addTrainingData(List.of(data));
    }

    @FXML
    public void addTrainingData(List<Point> datas) {
        toClassify.getItems().addAll(datas);
        //TODO: mainController.getModel().addDataToClassify(datas);
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void updateRobustness(double robustness) {
        this.robustness.setText(robustness + "%");
    }
}
