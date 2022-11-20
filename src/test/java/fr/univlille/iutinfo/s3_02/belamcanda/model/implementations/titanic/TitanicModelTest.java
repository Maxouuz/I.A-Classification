package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TitanicModelTest {
    private MVCModel model;

    @BeforeEach
    public void initialization() throws IOException {
        final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
        model = new TitanicLoader().createModelFromFile(DATA_PATH + "titanic.csv");
    }

    @Test
    public void titanic_title_should_be_Titanic() {
        assertEquals("Titanic", model.getTitle());
    }
}
