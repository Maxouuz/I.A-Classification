package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CSVLoaderTest {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;
    private List<Point> list;

    @BeforeEach
    public void initialization() throws IOException {
        String dataPath = DATA_PATH + "pokemon_test.csv";
        list = new CSVLoader().loadFromFile(PokemonPoint.class, dataPath, ',');
    }

    @Test
    public void loader_should_load_all_lines() {
        assertEquals(273, list.size());
    }

    @Test
    public void loaded_pokemons_should_be_the_right_pokemons() {
        PokemonPoint premier = (PokemonPoint) list.get(0);
        assertEquals("Tropius", premier.getValue(PokemonColumns.NAME.getColumn()));
        assertEquals(68, premier.getValue(PokemonColumns.ATTACK.getColumn()));
        PokemonPoint dernier = (PokemonPoint) list.get(272);
        assertEquals("Weavile", dernier.getValue(PokemonColumns.NAME.getColumn()));
        assertEquals(120, dernier.getValue(PokemonColumns.ATTACK.getColumn()));
    }
}