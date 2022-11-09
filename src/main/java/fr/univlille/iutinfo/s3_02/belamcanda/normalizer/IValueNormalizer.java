package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

public interface IValueNormalizer {

    public double normalize(Object value, Amplitude amplitude);

    public Object denormalize(double value, Amplitude amplitude);

}
