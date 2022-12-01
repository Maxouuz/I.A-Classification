package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NonNormalizableColumnTest {

    @Test
    void get_normalized_value_test(){
        IrisPoint point1 = new IrisPoint(1.,1.,1.,1., IrisVariety.SETOSA);
        NonNormalizableColumn nonNorma = new NonNormalizableColumn("norma", 0.);

        assertEquals(0., nonNorma.getNormalizedValue(point1));
    }
}
