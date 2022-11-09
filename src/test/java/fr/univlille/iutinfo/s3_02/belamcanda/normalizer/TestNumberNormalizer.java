package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestNumberNormalizer {
    @Test
    public void number_is_correctly_normalized(){        
        Amplitude ampl = new Amplitude();
        int min = 2;
        int max =10;
        ampl.update(min);
        ampl.update(max);
        assertEquals((8.-min)/(max-min), new NumberNormalizer().normalize(8.0,ampl));
    }
}
