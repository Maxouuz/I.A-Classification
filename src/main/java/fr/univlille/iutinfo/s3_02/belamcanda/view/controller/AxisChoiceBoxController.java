package fr.univlille.iutinfo.s3_02.belamcanda.view.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class AxisChoiceBoxController {
    @FXML private ChoiceBox<Column> xColCB;
    @FXML private ChoiceBox<Column> yColCB;
    private MainController mainController;

    public void initChoiceBoxes(MainController mainController) {
        this.mainController = mainController;
        MVCModel model = mainController.getModel();
        setChoiceBox(xColCB, model.defaultXCol());
        setChoiceBox(yColCB, model.defaultYCol());
    }

    private void setChoiceBox(ChoiceBox<Column> choiceBox, Column defaultCol) {
        MVCModel model = mainController.getModel();
        choiceBox.getItems().addAll(model.getColumns());
        choiceBox.getSelectionModel().select(defaultCol);
        choiceBox.setOnAction(e -> mainController.updateChartAxis());
    }

    public Column getXCol() {
        return xColCB.getSelectionModel().getSelectedItem();
    }

    public Column getYCol() {
        return yColCB.getSelectionModel().getSelectedItem();
    }
}
