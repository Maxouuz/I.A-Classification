package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NonNormalizableColumnTest {

    @Test
    void get_normalized_value_test(){
        IrisPoint point1 = new IrisPoint(1.,1.,1.,1., IrisVariety.SETOSA);
        NonNormalizableColumn nonNorma = new NonNormalizableColumn("norma", 0.);

        assertEquals(0., nonNorma.getNormalizedValue(point1));
    }

    @Test
    void compare_two_points_no_normalizable_column(){
        IrisPoint point1 = new IrisPoint(1.,1.,1.,1., IrisVariety.SETOSA);
        IrisPoint point2 = new IrisPoint(1.5,1.,1.,1., IrisVariety.VIRGINICA);
        NonNormalizableColumn nonNorma = new NonNormalizableColumn("norma", 0.);

        assertEquals(0.,nonNorma.compare(point1, point2) );
    }
}
