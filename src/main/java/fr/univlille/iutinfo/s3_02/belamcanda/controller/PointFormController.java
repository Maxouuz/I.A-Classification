package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PointFormController {
    @FXML private GridPane grid;

    public void generateForm(MVCModel model) {
        int row = 0;
        for (Column col: model.getColumns()) {
            Label fieldName = new Label(col.getName() + ":");
            Node input = getWidgetOfColumn();
            grid.addRow(row++, fieldName, input);
        }
    }

    private static Node getWidgetOfColumn() {
        Node widget = new TextField();
        /**
         * TODO: Les modifications commencent ici
         */
        return widget;
    }
}
