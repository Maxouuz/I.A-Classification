package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonPointTest {
    @Test
    void the_name_of_label_is_correct(){
        PokemonPoint point1 = new PokemonPoint();
        point1.name = "gratadmorv";
        point1.attack = 1;
        point1.defense = 20;
        point1.hp = 100;
        String test = String.format("%s :\n\tatk : %d\n\tdef : %d\n\thp  : %d",point1.name.toUpperCase(), point1.attack, point1.defense, point1.hp);
        assertEquals(test, point1.toLabel());
    }

    @Test
    void the_to_string_is_correct(){
        PokemonPoint point1 = new PokemonPoint();
        point1.name = "boustiflor";
        assertEquals("boustiflor", point1.toString());
    }
}
