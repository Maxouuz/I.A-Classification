package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CSVLoaderTest {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;
    private List<PokemonPoint> list;

    @BeforeEach
    public void initialization() throws IOException {
        String dataPath = DATA_PATH + "pokemon_test.csv";
        CSVLoader<PokemonPoint> loader = new CSVLoader<>();
        list = loader.loadFromFile(PokemonPoint.class, dataPath, ',');
    }

    @Test
    public void loader_should_load_all_lines() {
        assertEquals(273, list.size());
    }

    @Test
    public void loaded_pokemons_should_be_the_right_pokemons() throws NoSuchFieldException, IllegalAccessException {
        PokemonPoint premier = list.get(0);
        assertEquals("Tropius", premier.getValueFromString("name"));
        assertEquals(68, premier.getValueFromString("attack"));
        PokemonPoint dernier = list.get(272);
        assertEquals("Weavile", dernier.getValueFromString("name"));
        assertEquals(120, dernier.getValueFromString("attack"));
    }
}