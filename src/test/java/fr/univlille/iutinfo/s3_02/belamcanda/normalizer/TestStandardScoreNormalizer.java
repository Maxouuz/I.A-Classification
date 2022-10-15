package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestStandardScoreNormalizer {
    static StandardScoreNormalizer normalizer;
    static List<Integer> values;
    static double DELTA = .005;

    @BeforeAll
    public static void set_test_values(){
        values = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            values.add(i);
        }
        normalizer = new StandardScoreNormalizer(values);
    }

    @Test
    public void mean_should_be_five(){
        assertEquals(5, normalizer.getMean());
    }

    @Test
    public void standard_deviation_should_be_three_and_wheelbarrows(){
        assertEquals(3.162, normalizer.getStandardDeviation(), DELTA);
    }

    @Test
    public void standard_score_should_be_correct(){
        int i = 0;
        assertEquals(-1.581, normalizer.normalize(i++), DELTA);
        assertEquals(-1.265, normalizer.normalize(i++), DELTA);
        assertEquals(-0.948, normalizer.normalize(i++), DELTA);
        assertEquals(-0.632, normalizer.normalize(i++), DELTA);
        assertEquals(-0.316, normalizer.normalize(i++), DELTA);
        assertEquals(0, normalizer.normalize(i++), DELTA);
        assertEquals(0.316, normalizer.normalize(i++), DELTA);
        assertEquals(0.632, normalizer.normalize(i++), DELTA);
        assertEquals(.948, normalizer.normalize(i++), DELTA);
        assertEquals(1.265, normalizer.normalize(i++), DELTA);
        assertEquals(1.581, normalizer.normalize(i++), DELTA);
    }


    
}
