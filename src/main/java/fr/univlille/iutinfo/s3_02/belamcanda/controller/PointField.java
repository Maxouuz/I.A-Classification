package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.scene.Node;

import java.lang.reflect.Field;

public abstract class PointField {
    protected Field field;

    protected PointField(Field field) {
        this.field = field;
        createWidget();
    }

    protected abstract void createWidget();
    public abstract Node getWidget();
    public abstract void setValue(Point p) throws IllegalAccessException;
}
