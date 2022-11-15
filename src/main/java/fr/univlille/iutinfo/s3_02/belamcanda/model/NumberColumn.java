package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;

public class NumberColumn extends NormalizableColumn{
    public NumberColumn(String name, double weight) {
        super(name, weight, new NumberNormalizer());
    }

    public NumberColumn(String name) {
        this(name, 1.);
    }
}
