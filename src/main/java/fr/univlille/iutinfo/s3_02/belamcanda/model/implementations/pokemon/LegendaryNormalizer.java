package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.OrdinalNormalizer;

public class LegendaryNormalizer extends OrdinalNormalizer {

    @Override
    public double normalize(Object value, Amplitude amplitude) {
        Legendary type = (Legendary) value;
        return normalize(type.ordinal(), Legendary.values().length);
    }
}
