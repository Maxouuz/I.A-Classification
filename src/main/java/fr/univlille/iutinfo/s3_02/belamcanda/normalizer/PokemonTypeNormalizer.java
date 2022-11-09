package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

public class PokemonTypeNormalizer implements IValueNormalizer{
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        return 0;
    }

    @Override
    public Object denormalize(double value, Amplitude amplitude) {
        return null;
    }
}
