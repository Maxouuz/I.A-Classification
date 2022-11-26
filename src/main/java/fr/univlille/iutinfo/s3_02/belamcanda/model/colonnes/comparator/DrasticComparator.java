package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator;

public class DrasticComparator implements ColumnComparator {
    @Override
    public double compare(double d1, double d2) {
        return d1 == d2 ? 0.0 : 1.0;
    }
}
