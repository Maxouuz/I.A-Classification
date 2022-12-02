package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BeanTest {
    private final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;

    @Test
    void getting_an_attribute_from_its_name_should_work() throws IOException, NoSuchFieldException, IllegalAccessException {
        String dataPath = DATAPATH + "pokemon_test.csv";
        Point tropius = new CSVLoader().loadFromFile(CSVModel.POKEMON, dataPath).get(0);
        assertEquals("Tropius", tropius.getValueFromString("name"));
    }

    @Test
    void getting_an_attribute_from_its_column_should_work() throws IOException {
        String dataPath = DATAPATH + "pokemon_test.csv";
        Point tropius = new CSVLoader().loadFromFile(CSVModel.POKEMON, dataPath).get(0);
        assertEquals("Tropius", tropius.getValue(PokemonColumns.NAME.getColumn()));
    }

    @Test
    void no_error_should_be_raised_when_requesting_all_pokemon_columns() throws IOException {
        String dataPath = DATAPATH + "pokemon_test.csv";
        Point tropius = new CSVLoader().loadFromFile(CSVModel.POKEMON, dataPath).get(0);
        for (Column col : IColumnDefinition.getColumns(PokemonColumns.values())) {
            assertDoesNotThrow(() -> tropius.getValue(col));
        }
    }

    @Test
    void no_error_should_be_raised_when_requesting_all_titanic_columns() throws IOException {
        String dataPath = DATAPATH + "titanic.csv";
        Point titanic = new CSVLoader().loadFromFile(CSVModel.TITANIC, dataPath).get(0);
        for (Column col : IColumnDefinition.getColumns(TitanicColumns.values())) {
            assertDoesNotThrow(() -> titanic.getValue(col));
        }
    }
}