package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import java.util.List;

public class NullNormalizer implements IValueNormalizer{
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        return 0.;
    }
}
