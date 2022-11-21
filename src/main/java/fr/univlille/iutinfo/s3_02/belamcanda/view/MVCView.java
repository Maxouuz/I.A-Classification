package fr.univlille.iutinfo.s3_02.belamcanda.view;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class MVCView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = getParent();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private Parent getParent() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Main.fxml"));
        return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
