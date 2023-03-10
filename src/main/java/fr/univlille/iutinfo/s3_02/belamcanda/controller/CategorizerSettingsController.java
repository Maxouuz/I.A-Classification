package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.Distance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.ManhattanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.RandomDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.view.ColumnIsUsedValueFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.view.ColumnWeightValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class CategorizerSettingsController {
    public static final int MIN_K = 1;
    public static final int MAX_K = 100;
    public static final int DEFAULT_K = 3;
    @FXML private Label robustness;
    @FXML private Label dataTestFilename;
    @FXML private ChoiceBox<Distance> distanceMethod;
    @FXML private Spinner<Integer> kSpinner;
    private Categorizer categorizer;
    @FXML private TableView<Column> columnList;
    @FXML private TableColumn<Column, String> nameColumn;
    @FXML private TableColumn<Column, Spinner<Double>> weightColumn;
    @FXML private TableColumn<Column, CheckBox> usedColumn;

    public int getK() {
        return kSpinner.getValue();
    }

    @FXML
    public void initialize() {
        weightColumn.setCellValueFactory(new ColumnWeightValueFactory());
        usedColumn.setCellValueFactory(new ColumnIsUsedValueFactory());
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    public void initCategorizerSettings(MainController mainController) {
        MVCModel model = mainController.getModel();
        initK();
        createCategorizer(model);
        dataTestFilename.setText("Aucun fichier chargé");
        initDistanceMethod(mainController);
        createTableView(model.getNormalizableColumns());
    }

    private void initK() {
        kSpinner.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_K, MAX_K, DEFAULT_K)
        );
        kSpinner.valueProperty().addListener(e -> categorizer.setK(getK()));
    }

    private void initDistanceMethod(MainController mainController) {
        distanceMethod.getItems().setAll(new EuclideanDistance(), new ManhattanDistance(), new RandomDistance());
        distanceMethod.getSelectionModel().select(0);
        distanceMethod.setOnAction(e -> {
            Distance selected = distanceMethod.getSelectionModel().getSelectedItem();
            mainController.setDistanceMethod(selected);
        });
    }

    public void createCategorizer(MVCModel model) {
        categorizer = new Categorizer(model, new EuclideanDistance(), getK());
    }

    public void createTableView(List<Column> columns) {
        columnList.getItems().clear();
        for (Column column: columns) {
            columnList.getItems().add(column);
        }
    }

    public double getRobustness() {
        return categorizer.getRobustness();
    }

    public void updateRobustness(double robustness) {
        this.robustness.setText(toStringRobustness(robustness) + robustnessMethodDescription());
    }

    private String robustnessMethodDescription() {
        if (categorizer.isCrossValidationUsed()) {
            return " (cross-validation)";
        }
        return "";
    }

    private String toStringRobustness(double robustness) {
        double nbDecimals = 100.0;
        return Math.round(robustness * 100.0 * nbDecimals) / nbDecimals + "%";
    }

    public void setTestDataFileName(String filename) {
        dataTestFilename.setText(filename);
    }

    public void setDistanceMethod(Distance selected) {
        categorizer.setDistanceMethod(selected);
    }
}
