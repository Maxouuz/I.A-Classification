package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class OrdinalNormalizerTest {

    @Test
    void normalize_legendary() {
        Legendary zero = Legendary.TRUE;
        Legendary one = Legendary.FALSE;
        assertEquals(0, new OrdinalNormalizer<Legendary>().normalize(zero, null));
        assertEquals(1, new OrdinalNormalizer<Legendary>().normalize(one, null));
    }

    @Test
    void normalize_pokemon_type() {
        PokemonType[] values = PokemonType.values();
        for (PokemonType type : values) {
            assertEquals((type.ordinal() * 1.0) / (values.length - 1), new OrdinalNormalizer<PokemonType>().normalize(type, null));
        }
    }

    @Test
    void is_null() {
        assertFalse(new OrdinalNormalizer<>().isNull());
    }

    @Test
    void need_amplitude() {
        assertFalse(new OrdinalNormalizer<>().needAmplitude());
    }

}