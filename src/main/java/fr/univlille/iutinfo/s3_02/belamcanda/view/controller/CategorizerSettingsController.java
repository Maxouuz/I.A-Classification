package fr.univlille.iutinfo.s3_02.belamcanda.view.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class CategorizerSettingsController {
    public static final int MIN_K = 0;
    public static final int MAX_K = 100;
    public static final int DEFAULT_K = 3;
    @FXML private Spinner<Integer> kSpinner;

    public int getK() {
        return kSpinner.getValue();
    }

    @FXML
    public void initialize() {
        kSpinner.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_K, MAX_K, DEFAULT_K)
        );
    }
}
