package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class ChooseModelController {
    @FXML private ChoiceBox<CSVModel> modelList;

    private CSVModel selected;

    public void initialize() {
        modelList.getItems().addAll(CSVModel.values());
    }

    public void chooseModel() {
        selected = modelList.getSelectionModel().getSelectedItem();
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) modelList.getScene().getWindow();
        stage.close();
    }

    public CSVModel getSelected() {
        return selected;
    }
}
