package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestBooleanNormalizer {
    @Test
    void boolean_is_correctly_normalized(){
        assertEquals(1.0,new BooleanNormalizer().normalize(true));
        assertEquals(0.0,new BooleanNormalizer().normalize(false));
    }
}
