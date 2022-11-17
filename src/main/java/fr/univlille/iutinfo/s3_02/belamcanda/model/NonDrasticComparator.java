package fr.univlille.iutinfo.s3_02.belamcanda.model;

public class NonDrasticComparator implements ColumnComparator {
    @Override
    public double compare(double d1, double d2) {
        return Math.abs(d1 - d2);
    }
}
