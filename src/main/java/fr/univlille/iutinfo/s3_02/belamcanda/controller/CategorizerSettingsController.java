package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
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
        kSpinner.setValueFactory(
            new SpinnerValueFactory.IntegerSpinnerValueFactory(MIN_K, MAX_K, DEFAULT_K)
        );
        kSpinner.valueProperty().addListener(e -> categorizer.setK(getK()));
        weightColumn.setCellValueFactory(new ColumnWeightValueFactory());
        usedColumn.setCellValueFactory(new ColumnIsUsedValueFactory());
        setNameColumnCellFactory();
    }

    private void setNameColumnCellFactory() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
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
        this.robustness.setText(toStringRobustness(robustness));
    }

    private String toStringRobustness(double robustness) {
        final double nbDecimals = 100.0;
        return Math.round(robustness * 100.0 * nbDecimals) / nbDecimals + "%";
    }

    public void setTestDataFileName(String filename) {
        dataTestFilename.setText(filename);
    }
}
