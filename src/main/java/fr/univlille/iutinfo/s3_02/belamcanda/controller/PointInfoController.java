package fr.univlille.iutinfo.s3_02.belamcanda.controller;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PointInfoController {
    @FXML
    private Label pointDescription;

    @FXML
    public void setPointDescription(Point point, Column... columns) {
        StringBuilder acc = new StringBuilder();
        for (Column column: columns) {
            String attributeDescription = column.getName() + ": " + point.getStringValue(column) + "\n";
            acc.append(attributeDescription);
        }
        pointDescription.setText(acc.toString());
    }
}
