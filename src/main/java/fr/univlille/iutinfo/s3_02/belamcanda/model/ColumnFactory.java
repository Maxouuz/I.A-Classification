package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.BooleanNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;

public final class ColumnFactory {
    private ColumnFactory() {}

    public static Column numberColumn(String name, double weight) {
        return new NormalizableColumn(name, weight, new NumberNormalizer());
    }

    public static Column numberColumn(String name) {
        return numberColumn(name, 1);
    }

    public static Column booleanColumn(String name, double weight) {
        return new NormalizableColumn(name, weight, new BooleanNormalizer());
    }

    public static Column booleanColumn(String name) {
        return booleanColumn(name, 1);
    }
}
