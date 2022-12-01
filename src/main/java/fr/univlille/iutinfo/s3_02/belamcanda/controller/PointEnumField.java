package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

import java.lang.reflect.Field;
import java.util.Arrays;

public class PointEnumField extends PointField {
    private ComboBox<?> cb;

    protected PointEnumField(Field field) {
        super(field);
    }

    @Override
    protected void createWidget() {
        Class<?> clazz = field.getType();
        ObservableList<?> list = FXCollections.observableList(Arrays.asList(clazz.getEnumConstants()));
        cb = new ComboBox<>(list);
        cb.getSelectionModel().select(0);
    }

    @Override
    public Node getWidget() {
        return cb;
    }

    @Override
    public void setValue(Point p) throws IllegalAccessException {
        Object selectedItem = cb.getSelectionModel().getSelectedItem();
        field.set(p, selectedItem);
    }
}
