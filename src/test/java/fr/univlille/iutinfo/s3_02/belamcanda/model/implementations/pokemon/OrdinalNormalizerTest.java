package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.OrdinalNormalizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdinalNormalizerTest {

    @Test
    void normalize() {
        Legendary zero = Legendary.TRUE;
        Legendary one = Legendary.FALSE;
        assertEquals(0, new LegendaryNormalizer().normalize(zero, null));
        assertEquals(1, new LegendaryNormalizer().normalize(one, null));
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