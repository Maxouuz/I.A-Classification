package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonLoader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BeanTest {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;

    @Test
    void getting_an_attribute_from_its_name_should_work() throws IOException, NoSuchFieldException, IllegalAccessException {
        String dataPath = DATA_PATH + "pokemon_test.csv";
        PokemonPoint tropius = new PokemonLoader().loadFromFile(dataPath).get(0);
        assertEquals("Tropius", tropius.getValueFromString("name"));
    }

    @Test
    void getting_an_attribute_from_its_column_should_work() throws IOException, NoSuchFieldException, IllegalAccessException {
        String dataPath = DATA_PATH + "pokemon_test.csv";
        PokemonPoint tropius = new PokemonLoader().loadFromFile(dataPath).get(0);
        assertEquals("Tropius", tropius.getValue(PokemonColumns.NAME.getColumn()));
    }

    @Test
    void no_error_should_be_raised_when_requesting_all_columns() throws IOException {
        String dataPath = DATA_PATH + "pokemon_test.csv";
        PokemonPoint tropius = new PokemonLoader().loadFromFile(dataPath).get(0);
        for (Column col : IColumnDefinition.getColumns(PokemonColumns.values())) {
            assertDoesNotThrow(() -> tropius.getValue(col));
        }

    }
}