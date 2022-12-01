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

    public void updateRobustness(double robustness) {
        this.robustness.setText(toStringRobustness(robustness));
    }

    private String toStringRobustness(double robustness) {
        final double nbDecimals = 100.0;
        return Math.round(robustness * 100.0 * nbDecimals) / nbDecimals + "%";
    }
}
