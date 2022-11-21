package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class CategorizerTest {
    private MVCModel model;
    private Categorizer categorizer;

    @BeforeEach
    public void initialization() throws IOException {
        final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
        model = new PokemonLoader().createModelFromFile(DATA_PATH + "pokemon_train.csv");
        categorizer = new Categorizer(model, new EuclideanDistance(), 3);
    }

    @Test
    public void pokemon_that_is_surely_legendary_is_categorised_as_legendary() {
        Point rayquaza = findPointByName("Rayquaza");
        // TODO: Utiliser le polymorphisme pour les catégories pour pouvoir récupérer une catégorie facilement
        // assertEquals(Not legendary, categorizer.categorize(rayquaza));
    }

    @Test
    public Point findPointByName(String name) {
        Column columnName = PokemonColumns.NAME.getColumn();
        for (Point point: model) {
            if (point.getValue(columnName).equals(name)) {
                return point;
            }
        }
        throw new IllegalArgumentException();
    }
}