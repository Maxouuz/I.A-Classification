package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonLoaderTest {
    final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    void pokemon_loader_should_load_pokemon_beans() throws IOException {
        String dataPath = DATAPATH + "pokemon_test.csv";
        List<Point> list = new CSVLoader().loadFromFile(CSVModel.POKEMON, dataPath);
        assertEquals(273, list.size());
        PokemonPoint premier = (PokemonPoint) list.get(0);
        assertEquals("Tropius", premier.getValue(PokemonColumns.NAME.getColumn()));
        assertEquals(68, premier.getValue(PokemonColumns.ATTACK.getColumn()));
        PokemonPoint dernier = (PokemonPoint) list.get(272);
        assertEquals("Weavile", dernier.getValue(PokemonColumns.NAME.getColumn()));
        assertEquals(120, dernier.getValue(PokemonColumns.ATTACK.getColumn()));
    }
}