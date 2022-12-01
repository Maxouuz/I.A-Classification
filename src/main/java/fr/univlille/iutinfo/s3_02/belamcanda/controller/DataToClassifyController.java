package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class DataToClassifyController {
    @FXML private ListView<Point> toClassify;
    private MainController mainController;

    @FXML
    public void initialize() {
        toClassify.setOnMouseClicked(e -> {
            if (!toClassify.getSelectionModel().isEmpty()) {
                updatePointDescription();
            }
        });
    }

    private void updatePointDescription() {
        mainController.setPointDescription(toClassify.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void updateDataToClassify() {
        toClassify.getItems().setAll(mainController.getModel().getDataToClassify());
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
