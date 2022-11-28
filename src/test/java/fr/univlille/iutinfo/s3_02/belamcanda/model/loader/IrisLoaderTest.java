package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IrisLoaderTest {final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    void iris_loader_should_load_iris_beans() throws IOException {
        String dataPath = DATA_PATH + "iris.csv";
        List<Point> list = new CSVLoader().loadFromFile(CSVModel.IRIS, dataPath);
        assertEquals(150, list.size());
        IrisPoint premier = (IrisPoint) list.get(0);
        assertEquals(5.1, premier.getValue(IrisColumns.SEPAL_LENGTH.getColumn()));
        assertEquals(IrisVariety.SETOSA, premier.getValue(IrisColumns.VARIETY.getColumn()));
        IrisPoint dernier = (IrisPoint) list.get(149);
        assertEquals(5.9, dernier.getValue(IrisColumns.SEPAL_LENGTH.getColumn()));
        assertEquals(IrisVariety.VIRGINICA, dernier.getValue(IrisColumns.VARIETY.getColumn()));
    }

    @Test
    void data_format_validator_checks_if_file_is_valid(){
        /** TODO Implémenter la fonctionnalité si on a le temps*/
        String dataPath = DATA_PATH + "iris.csv";
        // assertTrue(new CSVLoader().dataIsValid(dataPath));
    }
}