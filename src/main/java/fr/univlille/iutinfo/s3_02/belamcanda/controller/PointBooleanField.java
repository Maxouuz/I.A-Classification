package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

import java.lang.reflect.Field;
import java.util.List;

public class PointBooleanField extends PointField {

    private ComboBox<Boolean> cb;

    protected PointBooleanField(Field field) {
        super(field);
    }

    @Override
    protected void createWidget() {
        ObservableList<Boolean> list = FXCollections.observableList(List.of(true, false));
        cb = new ComboBox<>(list);
        cb.getSelectionModel().select(0);
    }

    @Override
    public Node getWidget() {
        return cb;
    }

    @Override
    public void setValue(Point p) throws IllegalAccessException {
        boolean selectedItem = cb.getSelectionModel().getSelectedItem();
        field.setBoolean(p, selectedItem);
    }
}
