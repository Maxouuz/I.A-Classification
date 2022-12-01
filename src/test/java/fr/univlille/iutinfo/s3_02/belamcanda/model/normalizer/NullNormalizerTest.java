package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NullNormalizerTest {
    @Test
    void normalized_value_of_a_value_is_always_0() {
        Amplitude ampli = new Amplitude();
        ampli.update(1, 2, 3, 4, 5);
        assertEquals(0, new NullNormalizer().normalize(1, ampli));
        assertEquals(0, new NullNormalizer().normalize(3, ampli));
        assertEquals(0, new NullNormalizer().normalize(5, ampli));
    }

    @Test
    void null_normalizer_is_null(){
        assertTrue(new NullNormalizer().isNull());
    }

    @Test
    void null_normalizer_need_amplitude(){
        assertFalse(new NullNormalizer().needAmplitude());
    }
}