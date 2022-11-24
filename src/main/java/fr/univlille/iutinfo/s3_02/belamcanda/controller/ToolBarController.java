package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToolBarController {
    private MainController mainController;

    @FXML
    public void addPoint() throws IOException {
        // TODO: Faire un peu de refactoring ici j'ai pas trop le temps là désolé
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PointForm.fxml"));
        Parent root = loader.load();
        PointFormController controller = loader.getController();
        controller.generateForm(mainController.getModel());
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    @FXML
    public void classify() {
        double robustness = mainController.getRobustness();
        mainController.updateRobustness(robustness);
    }

    public void injectMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
