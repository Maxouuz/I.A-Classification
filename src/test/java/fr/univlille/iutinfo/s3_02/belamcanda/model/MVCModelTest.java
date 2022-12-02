package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MVCModelTest {

    private MVCModel model;

    @BeforeEach
    void initialization() throws IOException {
        final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
        model = new CSVLoader().createModelFromFile(DATAPATH + "pokemon_test.csv");
    }

    @Test
    void iterator_should_browse_all_the_elements_in_the_csv() {
        int i = 0;
        for (Point element: model) {
            i++;
        }
        assertEquals(i, model.getNbLines());
    }

    @Test
    void get_used_columns_should_not_contains_not_selected_columns() {
        int usedColumns = model.getUsedColumns().size();
        Column usedColumn = model.getColumn(PokemonColumns.HP);
        usedColumn.setUsed(false);
        assertEquals(usedColumns - 1, model.getUsedColumns().size());
    }

    @Test
    void datas_are_reset_when_setting_new_lines() {
        assertEquals(273, model.getNbLines());

        List<Point> lines = new ArrayList<>();
        lines.add(new PokemonPoint());
        model.setLines(lines);

        assertEquals(1, model.getNbLines());
    }
}