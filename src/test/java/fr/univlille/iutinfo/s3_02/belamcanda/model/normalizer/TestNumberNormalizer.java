package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestNumberNormalizer {
    @Test
    void number_is_correctly_normalized(){        
        Amplitude ampl = new Amplitude();
        int min = 2;
        int max =10;
        ampl.update(min, max);
        assertEquals((8.-min)/(max-min), new NumberNormalizer().normalize(8.0,ampl));
    }

    @Test
    void normalized_value_of_the_smallest_value_is_0(){
        Amplitude ampli = new Amplitude();
        ampli.update(5, 123, 2, 10);
        assertEquals(0, new NumberNormalizer().normalize(2, ampli));
    }

    @Test
    void normalized_value_of_the_biggest_value_is_0(){
        Amplitude ampli = new Amplitude();
        ampli.update(30, 5, 100, 12);
        assertEquals(1, new NumberNormalizer().normalize(100, ampli));
    }

    @Test
    void normalized_value_of_50_with_min_0_and_max_100_amplitude_is_0_50(){
        Amplitude ampli = new Amplitude();
        ampli.update(0, 50, 100);
        assertEquals(0.5, new NumberNormalizer().normalize(50, ampli));
    }
}
