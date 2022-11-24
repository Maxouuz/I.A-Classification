package fr.univlille.iutinfo.s3_02.belamcanda.view.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class TrainingDataController {
    @FXML private ListView<Point> trainingDataList;
    private MainController mainController;

    @FXML
    public void initialize() {
        trainingDataList.setOnMouseClicked(e -> updatePointDescription());
    }

    private void updatePointDescription() {
        mainController.setPointDescription(trainingDataList.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void addTrainingData(Point data) {
        addTrainingData(List.of(data));
    }

    @FXML
    public void addTrainingData(List<Point> datas) {
        trainingDataList.getItems().addAll(datas);
        mainController.getModel().addDataToClassify(datas);
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
