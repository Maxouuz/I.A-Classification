package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;

public class NormalizableColumn extends Column{
    public NormalizableColumn(String name, double weight, IValueNormalizer normalizer) {
        super(name, weight, normalizer);
    }

    public NormalizableColumn(String name, IValueNormalizer normalizer) {
        super(name, normalizer);
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }
}
