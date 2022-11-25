package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEuclideanDistance {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;
    private MVCModel model;
    private EuclideanDistance distance;
    private Column weightedColumn;

    @BeforeEach
    public void initialization() throws IOException {
        String dataPath = DATA_PATH + "iris.csv";
        weightedColumn = IrisColumns.SEPAL_WIDTH.getColumn();
        weightedColumn.setWeight(1.0);
        model = new CSVLoader().createModelFromFile(dataPath);
        distance = new EuclideanDistance();
    }

    @Test
    void two_identical_points_are_equal_to_zero() {
        IrisPoint point1 = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);
        IrisPoint point1Bis = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);

        assertEquals(0., distance.distance(model, point1, point1Bis));
    }

    @Test
    void points_are_more_or_less_close_to_zero_according_to_their_resemblance() {
        IrisPoint point1 = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);
        IrisPoint point2 = new IrisPoint(0., 0., 0., 0., IrisVariety.VIRGINICA);
        IrisPoint point3 = new IrisPoint(1., 1., 1., 0.9, IrisVariety.SETOSA);

        assertEquals(0.04166666666666663, distance.distance(model, point1, point3));
        assertEquals(1.20545016207218, distance.distance(model, point1, point2));
    }

    @Test
    void point_is_more_far_away_when_having_weight_in_the_different_attribute() {
        IrisPoint point1 = new IrisPoint(1., 1., 1., 1., IrisVariety.VIRGINICA);
        IrisPoint point2 = new IrisPoint(1., 2., 1., 1., IrisVariety.VIRGINICA);

        double beforeWeight = distance.distance(model, point1, point2);
        weightedColumn.setWeight(2.0);
        double withWeight = distance.distance(model, point1, point2);

        assertTrue(withWeight > beforeWeight);
    }
}
