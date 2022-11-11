package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

public class NullNormalizer implements IValueNormalizer{
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        return 0.;
    }
}
