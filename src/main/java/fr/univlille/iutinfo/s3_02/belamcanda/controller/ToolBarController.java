package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class ToolBarController {
    private MainController mainController;

    @FXML
    public void importModel() {
        try {
            File file = chooseCSVFile();
            if (file != null) {
                MVCModel model = new CSVLoader().createModelFromFile(file.toString());
                mainController.setNewModel(model);
            }
        } catch (IOException e) {
            showErrorMessage(e.getMessage());
        }
    }

    @FXML
    public void addDataToClassify() {
        // TODO: Répétition ici
        try {
            File file = chooseCSVFile();
            if (file != null) {
                mainController.setTestData(file.toString());
            }
        } catch (IOException e) {
            showErrorMessage(e.getMessage());
        }
    }

    private void showErrorMessage(String message) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Le fichier CSV est invalide");
        errorAlert.setContentText(message);
        errorAlert.showAndWait();
    }

    private static File chooseCSVFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));
        return fileChooser.showOpenDialog(new Stage());
    }

    @FXML
    public void addPoint() throws IOException {
        FXMLLoader loader = getPointLoader();

        Parent root = createPointForm(loader);
        showWindowAndWait(root);
        Point newPoint = getPointCreated(loader);

        if (newPoint != null) {
            mainController.addPointToClassify(newPoint);
        }
    }

    private Point getPointCreated(FXMLLoader loader) {
        PointFormController controller = loader.getController();
        return controller.getPoint();
    }

    private Parent createPointForm(FXMLLoader loader) throws IOException {
        Parent root = loader.load();
        PointFormController controller = loader.getController();
        controller.generateForm(mainController.getModel().getCsvModel());
        return root;
    }

    private FXMLLoader getPointLoader() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PointForm.fxml"));
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
    public void computeRobustness() {
        mainController.updateRobustness();
    }

    @FXML
    public void classify() {
        mainController.classify();
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
