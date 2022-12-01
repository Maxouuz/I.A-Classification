package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.NonNormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.NormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Execution(CONCURRENT)
class ColumnTest {
    final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    void is_normalizable_should_return_true_or_false_depending_on_the_normalizer() {
        Column normalized = new NormalizableColumn("Normalized", new NumberNormalizer());
        assertTrue(normalized.isNormalizable());
        Column notNormalized = new NonNormalizableColumn("NotNormalized");
        assertFalse(notNormalized.isNormalizable());
    }

    @Test
    void get_normalized_value_returns_the_normalized_value_of_the_current_column_of_the_point() {
        /* TODO: Compléter/Modifier ce test quand le normalizer et le point sont ajoutés */
        //Point point = new Point();
    }

    @Test
    void if_no_normalizer_is_given_column_sets_nullNormalizer_by_default(){
        /*
         * TODO : Compléter/Modifier ce test un fois qu'un normalizer par défault sera défini dans column 
         * dans le cas d'une colonne sans normalizer 
         */
        /*
        Column noNormalizerGiven = new Column("Test", null);
        Point point = new Point(noNormalizerGiven);
        Double defaultNormalizedValue = 0.;
        assertTrue(defaultNormalizedValue.equals(noNormalizerGiven.getNormalizedValue(point)));
        */
    }

    @Test
    void column_is_correctly_bound_to_the_model() {
        MVCModel model = new PokemonModel();
        for (Column columnWithAmplitude: model.getNormalizableColumns()) {
            assertEquals(columnWithAmplitude.getDataset(), model);
        }
    }

    @Test
    void column_is_attached_to_the_model_when_he_have_an_amplitude() {
        Column columnWithAmplitude = PokemonColumns.HP.getColumn();
        MVCModel model = new PokemonModel();
        assertTrue(model.observers().contains(columnWithAmplitude));
    }

    @Test
    void column_is_not_attached_to_the_model_when_he_dont_have_an_amplitude() {
        Column columnWithAmplitude = PokemonColumns.TYPE.getColumn();
        MVCModel model = new PokemonModel();
        assertFalse(model.observers().contains(columnWithAmplitude));
    }


    @Test
    void column_updates_amplitude_when_he_needs_it() throws Exception {
        MVCModel model = new PokemonModel();
        NormalizableColumn columnWithAmplitude = (NormalizableColumn) model.getColumn(PokemonColumns.HP);
        columnWithAmplitude.resetAmplitude();
        Amplitude ampli = columnWithAmplitude.amplitude();

        /** TODO CA BUG PERIODIQUMNET CETTE MERDE" */
        assertNull(ampli.getMin());
        model.setLines(new CSVLoader().loadFromFile(CSVModel.POKEMON, DATAPATH + "pokemon_test.csv"));
        assertNotEquals(null, ampli.getMin());
    }
}
