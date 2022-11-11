package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColumnTest {

    @Test
    public void is_normalizable_should_return_true_or_false_depending_on_the_normalizer() {
        Column normalized = new Column("Normalized", new NumberNormalizer());
        assertTrue(normalized.isNormalizable());
        Column notNormalized = new Column("NotNormalized", null);
        assertFalse(notNormalized.isNormalizable());
    }

    @Test
    public void get_normalized_value_returns_the_normalized_value_of_the_current_column_of_the_point() {
        /* TODO: Compléter/Modifier ce test quand le normalizer et le point sont ajoutés */
        //Point point = new Point();
    }

    @Test
    public void if_no_normalizer_is_given_column_sets_nullNormalizer_by_default(){
        /*
         * TODO : Compléter/Modifier ce test un fois qu'un normalizer par défault sera défini dans column 
         * dans le cas d'une colonne sans normalizer 
         */
        /*
        Column noNormalizerGiven = new Column("Test", null);
        Point point = new Point(noNormalizerGiven);
        Double defaultNormalizedValue = 0.;
        assertTrue(defaultNormalizedValue.equals(noNormalizerGiven.getNormalizedValue(point)));
        */
    }
}
