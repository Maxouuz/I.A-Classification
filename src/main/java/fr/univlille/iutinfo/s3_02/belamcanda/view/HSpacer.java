package fr.univlille.iutinfo.s3_02.belamcanda.view;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class HSpacer extends Region {
    public HSpacer(){
        HBox.setHgrow(this, Priority.ALWAYS);
    }
    public HSpacer(double width){
        this.setWidth(width);
    }
}