package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DataToClassifyController {
    @FXML private TableView<Point> toClassify;
    @FXML private TableColumn<Point, String> nameColumn;
    @FXML private TableColumn<Point, String> categoryColumn;
    private MainController mainController;

    @FXML
    public void initialize() {
        toClassify.setOnMouseClicked(e -> {
            if (!toClassify.getSelectionModel().isEmpty()) {
                updatePointDescription();
            }
        });
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().toString()));
        categoryColumn.setCellValueFactory(cellData -> {
            String category = cellData.getValue().category() == null ? "Inconnu" : cellData.getValue().category().toString();
            return new SimpleStringProperty(category);
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

    public void refreshTableView() {
        toClassify.refresh();
    }
}
