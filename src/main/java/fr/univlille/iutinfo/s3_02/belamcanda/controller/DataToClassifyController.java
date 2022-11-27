package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

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
    public void updateTrainingData() {
        toClassify.getItems().setAll(mainController.getModel().getDataToClassify());
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void updateRobustness(double robustness) {
        this.robustness.setText(robustness + "%");
    }
}
