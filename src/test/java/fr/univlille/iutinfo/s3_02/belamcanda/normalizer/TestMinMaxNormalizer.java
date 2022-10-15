package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestMinMaxNormalizer {
    List<Integer> values;
    double DELTA = .005;

    @BeforeAll
    public void set_test_values(){
        values = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            values.add(i);
        }
    }

    @Test
    public void min_value_should_be_zero(){
        assertEquals(0, MinMaxNormalizer.getMin(values), DELTA);
    }

    @Test
    public void max_value_should_be_ten(){
        assertEquals(10, MinMaxNormalizer.getMax(values), DELTA);
    }



    @Test
    public void values_should_be_normalized_correctly(){
        List<Double> normalized = new MinMaxNormalizer().normalize(values);
        for (int i = 0; i < values.size(); i++) {
            assertEquals(values.get(i).doubleValue() / 10, normalized.get(i), DELTA);
        }
    }

}
