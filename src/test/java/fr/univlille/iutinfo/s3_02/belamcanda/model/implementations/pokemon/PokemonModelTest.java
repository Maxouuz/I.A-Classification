package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Category;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

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
    public void all_columns_but_name_are_normalizable() {
        assertEquals(model.nbColumns() - 1, model.getNormalizableColumns().size());
    }

    @Test
    public void pokemon_dataset_has_2_categories() {
        Collection<Category> categoriesTitle = model.allCategories();
        assertEquals(2, categoriesTitle.size());
        assertNotNull(findCategoryByName("Legendary"));
        assertNotNull(findCategoryByName("Not legendary"));
    }

    @Test
    public void dataset_contains_31_legendary_pokemon() {
        assertEquals(31, findCategoryByName("Legendary").getNbLines());
    }

    private Category findCategoryByName(String name) {
        for (Category category: model.allCategories()) {
            if (category.getTitle().equals(name)) {
                return category;
            }
        }
        throw new IllegalArgumentException();
    }
}