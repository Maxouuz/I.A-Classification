package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Embarked;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TitanicPointTest {
    @Test
    void the_name_of_label_is_correct(){
        TitanicPoint point1 = new TitanicPoint();
        point1.name = "banane";
        point1.pClass = 1;
        point1.age = 20.0;
        point1.fare = 100.0;
        String test = String.format("%s :\n\tClass : %d\n\tAge : %.2f\n\tFare : %.2f", point1.name, point1.pClass, point1.age, point1.fare);
        assertEquals(test, point1.toLabel());
    }

    @Test
    void the_to_string_is_correct(){
        TitanicPoint point1 = new TitanicPoint();
        point1.name = "Jean";
        assertEquals("Jean", point1.toString());
    }

    @Test
    void two_passengers_are_different() {
        TitanicPoint point1 = new TitanicPoint();
        TitanicPoint point2 = new TitanicPoint();
        point1.age = 20.;
        point2.age = 22.;

        assertFalse(point1.equals(point2));
    }

    @Test
    void two_passengers_are_identical(){
        TitanicPoint point1 = new TitanicPoint();
        TitanicPoint point2 = new TitanicPoint();

        point1.age = 10.;
        point2.age = 10.;

        point1.fare = 1.;
        point2.fare = 1.;

        point1.name = "Jean";
        point2.name = "Jean";

        assertTrue(point1.equals(point2));
    }
}
