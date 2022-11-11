package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

public class NumberNormalizer implements IValueNormalizer{
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        Double v = ((Number) value).doubleValue();
        return (v - amplitude.getMin()) / (amplitude.getMax() - amplitude.getMin());
    }
}



