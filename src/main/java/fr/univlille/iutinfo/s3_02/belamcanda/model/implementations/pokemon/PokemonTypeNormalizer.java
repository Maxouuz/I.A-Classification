package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.ColumnComparator;
import fr.univlille.iutinfo.s3_02.belamcanda.model.DrasticComparator;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.OrdinalNormalizer;

public class PokemonTypeNormalizer extends OrdinalNormalizer {
    @Override
    public double normalize(Object value, Amplitude amplitude) {
        PokemonType type = (PokemonType) value;
        return normalize(type.ordinal(), PokemonType.values().length);
    }

}
