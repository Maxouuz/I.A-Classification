package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class ColumnIsUsedValueFactory implements Callback<TableColumn.CellDataFeatures<Column, CheckBox>, ObservableValue<CheckBox>> {
    @Override
    public ObservableValue<CheckBox> call(TableColumn.CellDataFeatures<Column, CheckBox> param) {
        Column col = param.getValue();
        CheckBox checkBox = new CheckBox();
        checkBox.selectedProperty().setValue(col.isUsed());
        checkBox.selectedProperty().addListener((ov, old_val, new_val) -> {
            col.setUsed(new_val);
        });
        return new SimpleObjectProperty<>(checkBox);
    }
}
