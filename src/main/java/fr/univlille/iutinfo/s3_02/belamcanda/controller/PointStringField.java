package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;

public class PointStringField extends PointField {
    private TextField tf;

    public PointStringField(Field field) {
        super(field);
    }

    @Override
    protected void createWidget() {
        tf = new TextField();
    }

    @Override
    public Node getWidget() {
        return tf;
    }

    @Override
    public void setValue(Point p) throws IllegalAccessException {
        String value = tf.textProperty().getValue();
        field.set(p, value);
    }
}
