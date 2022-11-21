package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonLoaderTest {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    public void pokemon_loader_should_load_pokemon_beans() throws IOException {
        String dataPath = DATA_PATH + "pokemon_test.csv";
        List<PokemonPoint> list = new PokemonLoader().loadFromFile(dataPath);
        assertEquals(273, list.size());
        PokemonPoint premier = list.get(0);
        assertEquals("Tropius", premier.getValue(PokemonColumns.NAME.getColumn()));
        assertEquals(68, premier.getValue(PokemonColumns.ATTACK.getColumn()));
        PokemonPoint dernier = list.get(272);
        assertEquals("Weavile", dernier.getValue(PokemonColumns.NAME.getColumn()));
        assertEquals(120, dernier.getValue(PokemonColumns.ATTACK.getColumn()));
    }
}