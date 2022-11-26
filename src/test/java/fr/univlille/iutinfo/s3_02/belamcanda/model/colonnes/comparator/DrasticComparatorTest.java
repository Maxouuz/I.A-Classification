package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator.DrasticComparator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrasticComparatorTest {
    @Test
    public void comparaison_between_same_values_is_equal_to_0() {
        assertEquals(0, new DrasticComparator().compare(5, 5));
    }

    @Test
    public void comparaison_between_different_values_is_equal_to_1() {
        assertEquals(1, new DrasticComparator().compare(2, 6));
    }
}