package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;

public final class ColumnFactory {
    private ColumnFactory() {}

    public static Column createColumn(String name, IValueNormalizer normalizer) {
        if (normalizer == null) {
            return new NonNormalizableColumn(name);
        }
        return new NormalizableColumn(name, normalizer);
    }
}
