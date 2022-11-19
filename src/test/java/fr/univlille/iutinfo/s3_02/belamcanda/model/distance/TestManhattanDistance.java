package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManhattanDistance {
    static double DELTA = 0.005;
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;


    @Test
    void two_identical_points_are_equal_to_zero() throws IOException {
        String dataPath = DATA_PATH + "iris.csv";

        IrisPoint point1 = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);
        IrisPoint point1Bis = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);

        ManhattanDistance manhattan = new ManhattanDistance();
        IrisLoader load = new IrisLoader();
        assertEquals(0., manhattan.distance(load.createModelFromFile(dataPath), point1, point1Bis));
    }

}
