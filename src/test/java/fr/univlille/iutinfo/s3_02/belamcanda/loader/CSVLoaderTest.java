package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.beans.PokemonBean;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CSVLoaderTest {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;
    @Test
    public void loader_should_load_all_lines() throws IOException {
        String dataPath = DATA_PATH + "pokemon_test.csv";
        List<PokemonBean> list = new CSVLoader<>().loadFromFile((Class)PokemonBean.class, dataPath, ',');
        assertEquals(273, list.size());
    }

    @Test
    public void loaded_pokemons_should_be_the_right_pokemons() throws IOException, NoSuchFieldException, IllegalAccessException {
        String dataPath = DATA_PATH + "pokemon_test.csv";
        List<PokemonBean> list = new CSVLoader<>().loadFromFile((Class)PokemonBean.class, dataPath, ',');
        PokemonBean premier = list.get(0);
        assertEquals("Tropius", premier.getValueFromString("name"));
        assertEquals(68, premier.getValueFromString("attack"));
        PokemonBean dernier = list.get(272);
        assertEquals("Weavile", dernier.getValueFromString("name"));
        assertEquals(120, dernier.getValueFromString("attack"));
    }
}