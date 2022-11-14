package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Embarked;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TitanicLoaderTest {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    public void titanic_loader_should_load_titanic_beans() throws IOException, NoSuchFieldException, IllegalAccessException {
        String dataPath = DATA_PATH + "titanic.csv";
        List<TitanicPoint> list = new TitanicLoader().loadFromFile(dataPath);
        assertEquals(891, list.size());
        TitanicPoint premier = list.get(0);
        assertEquals("Braund, Mr. Owen Harris", premier.getValueFromString("name"));
        assertEquals(Embarked.S, premier.getValueFromString("embarked"));
        TitanicPoint dernier = list.get(890);
        assertEquals("Dooley, Mr. Patrick", dernier.getValueFromString("name"));
        assertEquals(Embarked.Q, dernier.getValueFromString("embarked"));
    }
}