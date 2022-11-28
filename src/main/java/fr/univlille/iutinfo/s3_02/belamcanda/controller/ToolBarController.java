package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ToolBarController {
    private MainController mainController;

    @FXML
    public void importModel() throws IOException {
        File file = chooseCSVFile();
        if (file != null) {
            MVCModel model = new CSVLoader().createModelFromFile(file.toString());
            mainController.setNewModel(model);
        }
    }

    @FXML
    public void addDataToClassify() {
        File file = chooseCSVFile();
        try {
            mainController.addDataToClassify(file.toString());
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException();
        }
    }

    private static File chooseCSVFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));
        return fileChooser.showOpenDialog(new Stage());
    }

    @FXML
    public void addPoint() throws IOException {
        FXMLLoader loader = getFxmlLoader("PointForm.fxml");

        Parent root = loader.load();
        PointFormController controller = loader.getController();
        controller.generateForm(mainController.getModel());

        showWindowAndWait(root);
    }

    private FXMLLoader getFxmlLoader(String resource) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(resource));
        return loader;
    }

    private void showWindowAndWait(Parent root) {
        Stage stage = new Stage();
        stage.setTitle("Ajout d'un point " + mainController.getModel().getTitle());
        stage.getIcons().add(new Image("/img/logo.png"));
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    public void classify() {
        mainController.updateRobustness();
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
