package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

public class BooleanNormalizer implements IValueNormalizer{
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        return ((boolean) value) ? 1.0 : 0.0;
    }

    public double normalize(Object value) {
        return normalize(value, null);
    }
}
