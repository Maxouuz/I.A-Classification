package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ColumnWeightValueFactory implements Callback<TableColumn.CellDataFeatures<Column, Spinner<Double>>, ObservableValue<Spinner<Double>>> {
    private static final double MIN_WEIGHT = 0;
    private static final double MAX_WEIGHT = 100;
    private static final double DEFAULT_WEIGHT = 1;

    @Override
    public ObservableValue<Spinner<Double>> call(TableColumn.CellDataFeatures<Column, Spinner<Double>> param) {
        Column col = param.getValue();
        Spinner<Double> spinner = new Spinner<>();
        spinner.setValueFactory(
                new SpinnerValueFactory.DoubleSpinnerValueFactory(MIN_WEIGHT, MAX_WEIGHT, DEFAULT_WEIGHT)
        );
        spinner.valueProperty().addListener(e -> col.setWeight(spinner.getValue()));
        return new SimpleObjectProperty<>(spinner);
    }
}
