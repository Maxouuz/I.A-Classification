package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator.ColumnComparator;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator.DrasticComparator;

public class NullNormalizer implements IValueNormalizer {
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        return 0.;
    }

    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public boolean needAmplitude() {
        return false;
    }

    @Override
    public ColumnComparator getComparator() {
        return new DrasticComparator();
    }
}
