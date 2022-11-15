package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.BooleanNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;

public class BooleanColumn extends NormalizableColumn{
    public BooleanColumn(String name, double weight) {
        super(name, weight, new BooleanNormalizer());
    }

    public BooleanColumn(String name) {
        this(name, 1.0);
    }
}
