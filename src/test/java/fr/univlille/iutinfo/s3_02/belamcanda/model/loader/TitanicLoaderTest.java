package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Embarked;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TitanicLoaderTest {
    public static final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    void titanic_loader_should_load_titanic_beans() throws IOException {
        String dataPath = DATAPATH + "titanic.csv";
        List<Point> list = new CSVLoader().loadFromFile(CSVModel.TITANIC, dataPath);
        assertEquals(891, list.size());
        TitanicPoint premier = (TitanicPoint) list.get(0);
        assertEquals("Braund, Mr. Owen Harris", premier.getValue(TitanicColumns.NAME.getColumn()));
        assertEquals(Embarked.S, premier.getValue(TitanicColumns.EMBARKED.getColumn()));
        TitanicPoint dernier = (TitanicPoint) list.get(890);
        assertEquals("Dooley, Mr. Patrick", dernier.getValue(TitanicColumns.NAME.getColumn()));
        assertEquals(Embarked.Q, dernier.getValue(TitanicColumns.EMBARKED.getColumn()));
    }

    @Test
    void data_format_validator_checks_if_file_is_valid() throws IOException {
        String dataPath = DATAPATH + "titanic.csv";
        assertTrue(new CSVLoader().fileIsValid(CSVModel.TITANIC, dataPath));
    }
}