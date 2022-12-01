package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.scene.Node;
import javafx.scene.control.TextField;

import java.lang.reflect.Field;

public class PointIntegerField extends PointField {
    private TextField tf;
    protected PointIntegerField(Field field) {
        super(field);
    }

    @Override
    protected void createWidget() {
        tf = new TextField();
        tf.textProperty().addListener((obs, o, n) -> tf.setText(n.replaceAll("[\\D]", "")));
        tf.setPromptText("entier");
    }

    @Override
    public Node getWidget() {
        return tf;
    }

    @Override
    public void setValue(Point p) throws IllegalAccessException {
        int value = Integer.parseInt(tf.textProperty().getValue());
        field.setInt(p, value);
    }
}
