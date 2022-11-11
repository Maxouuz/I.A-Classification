package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestAmplitude {
    static final double DELTA = .005;

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

    @Test
    public void average_should_be_same_value_when_having_one_value() {
        Amplitude ampli = new Amplitude();
        double value = 4.0;
        ampli.update(value);
        assertEquals(value, ampli.getAverage());
    }

    @Test
    public void average_should_be_the_average_of_the_current_value_with_the_previous_one() {
        Amplitude ampli = new Amplitude();
        ampli.update(2);
        ampli.update(4);
        assertEquals((2 + 4) / 2.0, ampli.getAverage());
        ampli.update(3);
        assertEquals((2 + 4 + 3) / 3.0, ampli.getAverage());
        ampli.update(1);
        assertEquals((2 + 4 + 3 + 1) / 4.0, ampli.getAverage());
    }

    @Test
    public void variance_should_be_zero_when_the_only_number_is_one() {
        Amplitude ampli = new Amplitude();
        ampli.update(1);
        assertEquals(0, ampli.getVariance());
    }

    @Test
    public void variance_should_be_the_variance_of_the_current_value_with_the_previous_one(){
        Amplitude ampli = new Amplitude();
        ampli.update(1);
        ampli.update(2);
        ampli.update(3);
        double avg = ampli.getAverage();
        assertEquals(1 / 3.0 * (Math.pow(1 - avg, 2) + Math.pow(2 - avg, 2) + Math.pow(3 - avg, 2)), ampli.getVariance(), DELTA);
    }
}
