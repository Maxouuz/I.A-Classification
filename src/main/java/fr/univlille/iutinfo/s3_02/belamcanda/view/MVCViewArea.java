package fr.univlille.iutinfo.s3_02.belamcanda.view;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public abstract class MVCViewArea extends VBox {
    MVCModel model;
    MVCView parent;
    MVCViewArea(MVCView parent){
        this.parent = parent;
        this.model = parent.model;
    }
}
