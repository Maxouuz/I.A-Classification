package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

public class NonNormalizableColumn extends Column {
    public NonNormalizableColumn(String name, double weight) {
        super(name, weight);
        used = false;
    }
    public NonNormalizableColumn(String name) {
        this(name, 1.);
    }

    @Override
    public double getNormalizedValue(Point point) {
        return 0;
    }

    @Override
    public Double compare(Point p1, Point p2) {
        return 0.0;
    }

    @Override
    public boolean isNormalizable() {
        return false;
    }
}