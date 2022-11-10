package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.beans.TitanicBean;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.titanic.Embarked;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TitanicLoaderTest {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    public void titanic_loader_should_load_titanic_beans() throws IOException {
        String dataPath = DATA_PATH + "titanic.csv";
        List<TitanicBean> list = new TitanicLoader().loadFromFile(dataPath);
        assertEquals(891, list.size());
        TitanicBean premier = list.get(0);
        assertEquals("Braund, Mr. Owen Harris", premier.getName());
        assertEquals(Embarked.S, premier.getEmbarked());
        TitanicBean dernier = list.get(890);
        assertEquals("Dooley, Mr. Patrick", dernier.getName());
        assertEquals(Embarked.Q, dernier.getEmbarked());
    }

    @Test
    @Disabled
    public void converting_beans_to_points_should_return_titanic_points() throws IOException {
        String dataPath = DATA_PATH + "titanic_test.csv";
        List<TitanicBean> list = new CSVLoader<>().loadFromFile((Class)TitanicBean.class, dataPath, ',');

    }

}