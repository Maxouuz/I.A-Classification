package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PointRecap extends VBox {
    Point point;

    public PointRecap(Point point, Column[] columns){
        this.point = point;
        Label attr;
        Label value;
        for (Column col : columns){
            attr = new Label(col.getName());
            value = new Label(point.getStringValue(col));
            getChildren().add(new HBox(attr, new HSpacer(), value));
        }
    }

}
