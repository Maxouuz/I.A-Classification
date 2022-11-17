package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.ColumnComparator;
import fr.univlille.iutinfo.s3_02.belamcanda.model.NonDrasticComparator;

public class NumberNormalizer implements IValueNormalizer{
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        Double v = ((Number) value).doubleValue();
        return (v - amplitude.getMin()) / (amplitude.getMax() - amplitude.getMin());
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean needAmplitude() {
        return true;
    }

    @Override
    public ColumnComparator getComparator() {
        return new NonDrasticComparator();
    }
}



