package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestMinMaxNormalizer {
    MinMaxNormalizer normalizer;
    List<Integer> values;
    double DELTA = .005;

    @BeforeAll
    public void set_test_values(){
        values = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            values.add(i);
        }
        normalizer = new MinMaxNormalizer(values);
    }

    @Test
    public void min_value_should_be_zero(){
        assertEquals(0, normalizer.getMin());
    }

    @Test
    public void max_value_should_be_ten(){
        assertEquals(10, normalizer.getMax());
    }

    @Test
    public void values_should_be_normalized_correctly(){
        for (Number n : values) {
            assertEquals(n.doubleValue() / 10, normalizer.normalize(n), DELTA);
        }
    }

}
