package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IrisLoaderTest {

    final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    void iris_loader_should_load_iris_beans() throws IOException {
        String dataPath = DATAPATH + "iris.csv";
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
    void load_model_should_return_correctly_specified_model() throws IOException {
        String dataPath = DATAPATH + "iris.csv";
        MVCModel iris = new CSVLoader().createModelFromFile(dataPath);
        assertEquals(iris.getTitle(), "Iris");
        assertEquals(iris.defaultXCol(), IrisColumns.PETAL_LENGTH.getColumn());
        assertEquals(iris.defaultYCol(), IrisColumns.PETAL_WIDTH.getColumn());
    }
}