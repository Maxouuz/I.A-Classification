package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator.ColumnComparator;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator.DrasticComparator;

public class BooleanNormalizer implements IValueNormalizer{
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        return ((boolean) value) ? 1.0 : 0.0;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean needAmplitude() {
        return false;
    }

    @Override
    public ColumnComparator getComparator() {
        return new DrasticComparator();
    }

    public double normalize(Object value) {
        return normalize(value, null);
    }
}
