package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestAmplitude {

    @Test
    public void min_and_max_is_equal_null_when_having_no_value(){
        Amplitude ampli = new Amplitude();
        if(ampli.getMax() ==  null){
            ampli.update(4.0);
            assertEquals(4.0, ampli.getMax());
        }
        if(ampli.getMin() == null){
            ampli.update(4.0);
            assertEquals(4.0, ampli.getMin());
        }
    }

    @Test
    public void min_and_max_should_be_same_value_when_having_one_value(){
        Amplitude ampli = new Amplitude();
        ampli.update(4.0);
        assertEquals(4.0, ampli.getMax());
        assertEquals(4.0, ampli.getMin());
    }

}
