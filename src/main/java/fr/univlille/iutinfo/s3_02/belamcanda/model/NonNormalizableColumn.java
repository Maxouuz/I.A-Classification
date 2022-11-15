package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NullNormalizer;

public class NonNormalizableColumn extends Column{
    public NonNormalizableColumn(String name, double weight) {
        super(name, weight, new NullNormalizer());
    }
    public NonNormalizableColumn(String name) {
        this(name, 1.);
    }

    @Override
    public boolean isNormalizable() {
        return false;
    }
}
