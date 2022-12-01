package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class PointFormController {
    @FXML
    private GridPane grid;
    private final List<PointField> fields;
    private CSVModel model;
    private Point newPoint;

    public PointFormController() {
        this.fields = new LinkedList<>();
    }

    public void generateForm(CSVModel model) {
        this.model = model;

        int row = 0;
        Class<? extends Point> clazz = this.model.getPointClass();
        for (Field f : clazz.getDeclaredFields()) {
            Label fieldName = new Label(f.getName() + ": ");
            PointField input = getWidgetOf(f);
            fields.add(input);
            grid.addRow(row++, fieldName, input.getWidget());
        }
    }

    private static PointField getWidgetOf(Field field) {
        Class<?> clazz = field.getType();
        if (clazz.isEnum()) return new PointEnumField(field);
        else if (isInt(clazz)) return new PointIntegerField(field);
        else if (isDouble(clazz)) return new PointDoubleField(field);
        return new PointStringField(field);
    }

    private static boolean isDouble(Class<?> clazz) {
        return clazz.equals(double.class) || clazz.equals(Double.class);
    }

    private static boolean isInt(Class<?> clazz) {
        return clazz.equals(Integer.class) || clazz.equals(int.class);
    }

    @FXML
    public void createPoint() {
        newPoint = model.createPoint();
        for (PointField field: fields) {
            try {
                field.setValue(newPoint);
            } catch (IllegalAccessException | NumberFormatException e) {
                newPoint = null;
                return;
            }
        }
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) grid.getScene().getWindow();
        stage.close();
    }

    public Point getPoint() {
        return newPoint;
    }
}
