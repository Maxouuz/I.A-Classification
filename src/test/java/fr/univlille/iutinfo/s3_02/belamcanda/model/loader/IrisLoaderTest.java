package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.quantitative_variables.IrisVariety;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IrisLoaderTest {final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;

    @Test
    public void iris_loader_should_load_iris_beans() throws IOException, NoSuchFieldException, IllegalAccessException {
        String dataPath = DATA_PATH + "iris.csv";
        List<IrisPoint> list = new IrisLoader().loadFromFile(dataPath);
        assertEquals(150, list.size());
        IrisPoint premier = list.get(0);
        assertEquals(5.1, premier.getValueFromString("sepalLength"));
        assertEquals(IrisVariety.SETOSA, premier.getValueFromString("variety"));
        IrisPoint dernier = list.get(149);
        assertEquals(5.9, dernier.getValueFromString("sepalLength"));
        assertEquals(IrisVariety.VIRGINICA, dernier.getValueFromString("variety"));
    }

    @Test
    @Disabled
    public void converting_beans_to_points_should_return_iris_points() throws IOException {
        String dataPath = DATA_PATH + "iris.csv";
        List<IrisPoint> list = new CSVLoader<IrisPoint>().loadFromFile(IrisPoint.class, dataPath, ',');
    }

}