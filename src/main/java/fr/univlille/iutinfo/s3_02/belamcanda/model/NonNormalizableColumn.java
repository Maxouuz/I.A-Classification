package fr.univlille.iutinfo.s3_02.belamcanda.model;

public class NonNormalizableColumn extends Column {
    public NonNormalizableColumn(String name, double weight) {
        super(name, weight);
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