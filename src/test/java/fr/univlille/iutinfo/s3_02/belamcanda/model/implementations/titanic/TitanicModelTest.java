package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TitanicModelTest {
    private MVCModel model;

    @BeforeEach
    void initialization() throws IOException {
        final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
        model = new CSVLoader().createModelFromFile(DATAPATH + "titanic.csv");
    }

    @Test
    void titanic_title_should_be_Titanic() {
        assertEquals("Titanic", model.getTitle());
    }

    @Test
    void titanic_default_x_col_is_survived(){
        assertEquals(TitanicColumns.SURVIVED.getColumn(), model.defaultXCol());
    }

    @Test
    void titanic_default_y_col_is_age(){
        assertEquals(TitanicColumns.AGE.getColumn(), model.defaultYCol());
    }
}
