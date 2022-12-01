package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;

public class PointDoubleField extends PointField {
    private TextField tf;

    protected PointDoubleField(Field field) {
        super(field);
    }

    @Override
    protected void createWidget() {
        tf = new TextField();
        tf.textProperty().addListener((obs, o, n) -> tf.setText(n.replaceAll("[^\\d.]", "")));
        tf.setPromptText("décimal");
    }

    @Override
    public Node getWidget() {
        return tf;
    }

    @Override
    public void setValue(Point p) throws IllegalAccessException {
        String value = tf.textProperty().getValue();
        field.setDouble(p, Double.parseDouble(value));
    }
}
