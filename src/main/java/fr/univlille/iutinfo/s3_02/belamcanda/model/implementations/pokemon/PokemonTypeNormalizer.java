package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;

public class PokemonTypeNormalizer implements IValueNormalizer {

    @Override
    public double normalize(Object value, Amplitude amplitude) {
        PokemonType type = (PokemonType) value;
        return type.ordinal() * 1.0 / PokemonType.values().length;
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean needAmplitude() {
        return false;
    }
}
