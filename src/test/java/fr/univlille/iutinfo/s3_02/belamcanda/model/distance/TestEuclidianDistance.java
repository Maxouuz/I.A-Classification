package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEuclidianDistance {
    static double DELTA = 0.005;
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;


    @Test
    void two_identical_points_are_equal_to_zero() throws IOException {
        String dataPath = DATA_PATH + "iris.csv";

        IrisPoint point1 = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);
        IrisPoint point1Bis = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);

        EuclidianDistance euclid = new EuclidianDistance();
        IrisLoader load = new IrisLoader();
        assertEquals(0., euclid.distance(load.createModelFromFile(dataPath), point1, point1Bis));
    }

    @Test
    void points_are_more_or_less_close_to_zero_according_to_their_resemblance() throws IOException {
        String dataPath = DATA_PATH + "iris.csv";

        IrisPoint point1 = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);
        IrisPoint point2 = new IrisPoint(0., 0., 0., 0., IrisVariety.VIRGINICA);
        IrisPoint point3 = new IrisPoint(1., 1., 1., 0.9, IrisVariety.SETOSA);

        EuclidianDistance euclid = new EuclidianDistance();
        IrisLoader load = new IrisLoader();
        assertEquals(0.6731345283372746, euclid.distance(load.createModelFromFile(dataPath), point1, point2));
        assertEquals(0.04166666666666663, euclid.distance(load.createModelFromFile(dataPath), point1, point3));
    }
}
