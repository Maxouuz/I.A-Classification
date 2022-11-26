package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator.ColumnComparator;

public interface IValueNormalizer {
    double normalize(Object value, Amplitude amplitude);
    boolean isNull();
    boolean needAmplitude();
    ColumnComparator getComparator();
}
