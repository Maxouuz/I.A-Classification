package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.view.ColumnIsUsedValueFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.view.ColumnWeightValueFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CategorizerSettingsController {
    public static final int MIN_K = 0;
    public static final int MAX_K = 100;
    public static final int DEFAULT_K = 3;
    @FXML private Spinner<Integer> kSpinner;
    private Categorizer categorizer;
    @FXML private TableView<Column> columnList;
    @FXML private TableColumn<Column, String> nameColumn;
    @FXML private TableColumn<Column, Spinner<Double>> weightColumn;
    @FXML private TableColumn<Column, CheckBox> isUsedColumn;

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
        isUsedColumn.setCellValueFactory(new ColumnIsUsedValueFactory());
        setNameColumnCellFactory();
    }

    private void setNameColumnCellFactory() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    public void createCategorizer(MVCModel model) {
        categorizer = new Categorizer(model, new EuclideanDistance(), getK());
    }

    public void createTableView(Column[] columns) {
        for (Column column: columns) {
            columnList.getItems().add(column);
        }
    }
}
