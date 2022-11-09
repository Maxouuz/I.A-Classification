/*package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestStandardScoreNormalizer {
    static List<Integer> values;
    static double DELTA = .005;

    @BeforeAll
    static public void set_test_values(){
        values = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            values.add(i);
        }
    }

    @Test
    public void mean_should_be_five(){
        assertEquals(5, StandardScoreNormalizer.getAverage(values), DELTA);
    }

    @Test
    public void variance_should_be_ten(){
        assertEquals(10, StandardScoreNormalizer.getVariance(values, StandardScoreNormalizer.getAverage(values)), DELTA);
    }

    @Test
    public void standard_score_should_be_correct(){
        int i = 0;
        List<Double> normalized = new StandardScoreNormalizer().normalize(values);
        assertEquals(-1.581, normalized.get(i++), DELTA);
        assertEquals(-1.265, normalized.get(i++), DELTA);
        assertEquals(-0.948, normalized.get(i++), DELTA);
        assertEquals(-0.632, normalized.get(i++), DELTA);
        assertEquals(-0.316, normalized.get(i++), DELTA);
        assertEquals(0, normalized.get(i++), DELTA);
        assertEquals(0.316, normalized.get(i++), DELTA);
        assertEquals(0.632, normalized.get(i++), DELTA);
        assertEquals(.948, normalized.get(i++), DELTA);
        assertEquals(1.265, normalized.get(i++), DELTA);
        assertEquals(1.581, normalized.get(i++), DELTA);
    }
    
}*/
