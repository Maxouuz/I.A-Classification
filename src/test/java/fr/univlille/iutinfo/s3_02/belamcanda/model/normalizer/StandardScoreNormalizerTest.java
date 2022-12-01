package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StandardScoreNormalizerTest {

    @Test
    void score_normalizer_is_null(){
        StandardScoreNormalizer standSc = new StandardScoreNormalizer();
        assertFalse(standSc.isNull());
    }

    @Test
    void score_normalizer_need_amplitude(){
        StandardScoreNormalizer standSc = new StandardScoreNormalizer();
        assertTrue(standSc.needAmplitude());
    }
}
