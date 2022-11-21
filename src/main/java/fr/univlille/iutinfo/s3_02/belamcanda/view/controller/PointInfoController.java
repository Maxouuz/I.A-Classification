package fr.univlille.iutinfo.s3_02.belamcanda.view.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PointInfoController {
    public VBox pointInfoTab;
    @FXML
    Label pointTitle;
    @FXML
    Label pointDescription;

    @FXML
    public void setPointDescription(Point point, Column[] columns) {
        StringBuilder acc = new StringBuilder();
        for (Column column: columns) {
            acc.append(column.getName()).append(": ").append(point.getStringValue(column)).append("\n");
        }
        pointDescription.setText(acc.toString());
    }
}
