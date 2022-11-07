package fr.univlille.iutinfo.s3_02.belamcanda;

import fr.univlille.iutinfo.s3_02.belamcanda.normalizer.MinMaxNormalizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColumnTest {
    @Test
    public void is_normalizable_should_return_true_when_column_have_a_normalizer() {
        /* TODO: décommenter ses lignes quand le normalizer est ajouté
        Column normalized = new Column(null, "column", 1, new NumberNormalizer());
        assertTrue(normalized.isNormalizable());
        */
        Column notNormalized = new Column(null, "column", 1, null);
        assertFalse(notNormalized.isNormalizable());
    }

    @Test
    public void get_normalized_value_returns_the_normalized_value_of_the_current_column_of_the_point() {
        /* TODO: Faire ce test quand le normalizer et le point sont ajoutés */
    }
}
