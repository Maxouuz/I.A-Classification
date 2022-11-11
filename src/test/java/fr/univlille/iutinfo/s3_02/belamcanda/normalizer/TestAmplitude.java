package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestAmplitude {

    @Test
    public void min_max_should_be_equal_after_first_update(){
        Amplitude ampli = new Amplitude();
        ampli.update(4.0);
        assertEquals(4.0, ampli.getMax());
        assertEquals(4.0, ampli.getMin());
        assertEquals(ampli.getMax(), ampli.getMin());
    }

    @Test
    public void min_and_max_should_be_same_value_when_having_one_value(){
        Amplitude ampli = new Amplitude();
        ampli.update(4.0);
        assertEquals(4.0, ampli.getMax());
        assertEquals(4.0, ampli.getMin());
    }

}
