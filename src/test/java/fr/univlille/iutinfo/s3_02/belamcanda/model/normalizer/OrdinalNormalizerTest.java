package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.LegendaryNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonTypeNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.OrdinalNormalizer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdinalNormalizerTest {

    @Test
    void normalize_legendary() {
        Legendary zero = Legendary.TRUE;
        Legendary one = Legendary.FALSE;
        Assertions.assertEquals(0, new LegendaryNormalizer().normalize(zero, null));
        assertEquals(1, new LegendaryNormalizer().normalize(one, null));
    }

    @Test
    void normalize_pokemon_type() {
        PokemonType[] values = PokemonType.values();
        for (PokemonType type : values) {
            assertEquals(type.ordinal() / (values.length - 1.0), new PokemonTypeNormalizer().normalize(type, null));
        }
    }

    @Test
    void is_null() {
        assertFalse(new LegendaryNormalizer().isNull());
    }

    @Test
    void need_amplitude() {
        assertFalse(new LegendaryNormalizer().needAmplitude());
    }

}