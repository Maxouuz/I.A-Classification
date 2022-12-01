package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class StandardScoreNormalizerTest {

    @Test
    void Score_normalizer_is_null(){
        StandardScoreNormalizer standSc = new StandardScoreNormalizer();
        assertFalse(standSc.isNull());
    }
}
