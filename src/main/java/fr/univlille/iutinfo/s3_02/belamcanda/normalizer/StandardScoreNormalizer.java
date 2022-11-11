package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

public class StandardScoreNormalizer implements IValueNormalizer {
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        Double v = ((Number) value).doubleValue();
        return (v - amplitude.getAverage()) / amplitude.getStandardDeviation();
    }
}
