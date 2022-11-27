package fr.univlille.iutinfo.s3_02.belamcanda.view.printers;

import fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer.Categorizer;

public class CategorizerPrinter extends Printer<Categorizer> {

    @Override
    public String toString(Categorizer obj) {
        return String.format("Categoriseur [distance: %s, K: %d]", obj.getDistanceMethod(), obj.getK());
    }
}
