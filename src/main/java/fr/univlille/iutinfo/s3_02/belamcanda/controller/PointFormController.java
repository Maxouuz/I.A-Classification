package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Field;
import java.util.Arrays;

public class PointFormController {
    @FXML
    private GridPane grid;

    public void generateForm(MVCModel model) {
        int row = 0;
        Class<? extends Point> clazz = model.pointClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Label fieldName = new Label(f.getName() + ": ");
            Node input = getWidgetOf(f.getType());
            grid.addRow(row++, fieldName, input);
        }
    }

    private static Node getWidgetOf(Class<?> clazz) {
        if (clazz.isEnum()) return enumWidget(clazz);
        else if (isInt(clazz)) return intWidget();
        else if (isDouble(clazz)) return doubleWidget();
        return new TextField();

    }

    private static boolean isDouble(Class<?> clazz) {
        return clazz.equals(double.class) || clazz.equals(Double.class);
    }

    private static boolean isInt(Class<?> clazz) {
        return clazz.equals(Integer.class) || clazz.equals(int.class);
    }

    private static Node doubleWidget() {
        TextField res = new TextField();
        res.textProperty().addListener((obs, o, n) -> res.setText(n.replaceAll("[^\\d.]", "")));
        res.setPromptText("décimal");
        return res;
    }

    private static Node intWidget() {
        TextField res = new TextField();
        res.textProperty().addListener((obs, o, n) -> res.setText(n.replaceAll("[\\D]", "")));
        res.setPromptText("entier");
        return res;
    }

    private static Node enumWidget(Class<?> clazz) {
        ObservableList<?> list = FXCollections.observableList(Arrays.asList(clazz.getEnumConstants()));
        ComboBox<?> res = new ComboBox<>(list);
        res.getSelectionModel().select(0);
        return res;
    }

}
