package fr.univlille.iutinfo.s3_02.belamcanda.view.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class CategorizerSettingsController {
    public static final int MIN_K = 0;
    public static final int MAX_K = 100;
    public static final int DEFAULT_K = 3;
    @FXML private Spinner<Integer> kSpinner;
    private Categorizer categorizer;


    public int getK() {
        return kSpinner.getValue();
    }

    @FXML
    public void initialize() {
        kSpinner.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_K, MAX_K, DEFAULT_K)
        );
        kSpinner.valueProperty().addListener(e -> updateCategorizer());
    }

    private void updateCategorizer() {
        categorizer.setK(getK());
    }

    public void injectMainController(MainController mainController) {
        categorizer = new Categorizer(mainController.getModel(), new EuclideanDistance(), getK());
    }
}
