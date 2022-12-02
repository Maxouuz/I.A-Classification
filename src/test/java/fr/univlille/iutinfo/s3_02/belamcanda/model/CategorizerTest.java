package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CategorizerTest {
    public static final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
    private MVCModel model;
    private Categorizer categorizer;

    @BeforeEach
    void initialization() throws IOException {
        model = new CSVLoader().createModelFromFile(DATAPATH + "pokemon_train.csv");
        categorizer = new Categorizer(model, new EuclideanDistance(), 3);
    }

    @Test
    void pokemon_that_is_surely_legendary_is_categorised_as_legendary() {
        Point rayquaza = findPointByName("Rayquaza");
        assertEquals(Legendary.TRUE, categorizer.categorize(rayquaza));
    }

    @Test
    void robustness_is_not_computed_by_cross_validation_when_having_test_datas() throws IOException {
        model.setTestData(DATAPATH + "pokemon_test.csv");
        assertNotEquals(categorizer.getRobustnessByCrossValidation(), categorizer.getRobustness());
    }

    @Test
    Point findPointByName(String name) {
        Column columnName = PokemonColumns.NAME.getColumn();
        for (Point point: model) {
            if (point.getValue(columnName).equals(name)) {
                return point;
            }
        }
        throw new IllegalArgumentException();
    }
}