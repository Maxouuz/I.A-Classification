package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestStandardScoreNormalizer {
    static List<Integer> values;
    static Amplitude ampli;
    static final double DELTA = .005;

    @BeforeAll
    static public void initialization(){
        values = new ArrayList<>();
        ampli = new Amplitude();
        for (int i = 0; i <= 10; i++) {
            values.add(i);
            ampli.update(i);
        }
    }

    @Test
    public void standard_score_should_be_correct(){
        int i = 0;
        List<Double> normalized = new ArrayList<>();
        for (int value: values) {
           normalized.add(new StandardScoreNormalizer().normalize(value, ampli));
        }
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
        assertEquals(1.581, normalized.get(i), DELTA);
    }
    
}
