package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PokemonModelTest {

    private MVCModel model;

    @BeforeEach
    public void initialization() throws IOException {
        final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
        model = new PokemonLoader().createModelFromFile(DATA_PATH + "pokemon_test.csv");
    }

    @Test
    public void pokemon_title_should_be_Pokemon() {
        assertEquals("Pokémon", model.getTitle());
    }

    @Test
    public void pokemon_default_x_col_is_base_egg_steps() {
        assertEquals(PokemonColumns.BASE_EGG_STEPS.getColumn(), model.defaultXCol());
    }

    @Test
    public void pokemon_default_y_col_is_capture_rate() {
        assertEquals(PokemonColumns.CAPTURE_RATE.getColumn(), model.defaultYCol());
    }

    @Test
    public void pokemon_test_csv_should_have_13_columns_like_the_csv() {
        assertEquals(13, model.nbColumns());
    }

    @Test
    public void pokemon_model_should_have_273_elements_like_the_csv() {
        assertEquals(273, model.getNbLines());
    }

    @Test
    public void all_the_columns_are_normalized() {
        assertEquals(model.nbColumns(), model.getNormalizableColumns().size());
    }
}