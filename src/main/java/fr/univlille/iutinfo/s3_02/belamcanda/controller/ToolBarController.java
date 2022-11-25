package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;

public class ToolBarController {
    private MainController mainController;

    @FXML
    public void importModel() throws IOException {
        FXMLLoader loader = getFxmlLoader("ChooseModel.fxml");
        Parent parent = loader.load();
        showWindowAndWait(parent);

        ChooseModelController controller = loader.getController();
        CSVModel model = controller.getSelected();

        FileChooser fileChooser = new FileChooser();
        String path = fileChooser.showOpenDialog(new Stage()).toString();
        mainController.setNewModel(new CSVLoader().createModelFromFile(model, path));
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

    private static void showWindowAndWait(Parent root) {
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
