package fr.univlille.iutinfo.s3_02.belamcanda.view.printers;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;

public class ModelPrinter extends Printer<MVCModel>{
    @Override
    public String toString(MVCModel obj) {
        return String.format("%s [entrainement: %d, à classer: %s]", obj.getClass().getSimpleName(), obj.getTrainingData().size(), obj.getDataToClassify().size());
    }
}
