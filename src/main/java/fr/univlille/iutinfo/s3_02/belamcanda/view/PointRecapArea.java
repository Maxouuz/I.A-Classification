package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.NullPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PointRecapArea extends MVCViewArea {
    Point point1;
    Point point2;
    PointRecap recap1;
    PointRecap recap2;
    Label dist;



    public PointRecapArea(MVCView parent){
        super(parent);
        point1 = new NullPoint();
        point2 = new NullPoint();
        recap1 = new PointRecap(point1, model.getColumns());
        recap2 = new PointRecap(point2, model.getColumns());
        updateDist(point1, point2);
        this.getChildren().add(new HBox(recap1, recap2));
        this.getChildren().add(dist);
    }

    private void updateDist(Point point1, Point point2) {
        dist = new Label("Distance = ");
    }
}
