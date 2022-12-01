package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonDrasticComparatorTest {
    @Test
    void comparaison_between_same_values_is_equal_to_0() {
        assertEquals(0, new NonDrasticComparator().compare(5, 5));
    }

    @Test
    void comparaison_between_different_values_is_equal_to_the_difference_of_the_two_values() {
        assertEquals(3, new NonDrasticComparator().compare(6, 3));
    }

    @Test
    void comparaison_between_different_values_cant_be_negative() {
        assertEquals(3, new NonDrasticComparator().compare(6, 9));
    }
}