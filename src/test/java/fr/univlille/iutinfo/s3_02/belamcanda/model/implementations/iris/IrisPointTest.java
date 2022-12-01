package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IrisPointTest {

    @Test
    void the_name_of_label_is_correct(){
        IrisPoint point1 = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);
        String test =  String.format("Iris (l, h)\n\tSepal (%.2f, %.2f)\n\tPetal (%.2f, %.2f)", point1.sepalLength, point1.sepalWidth, point1.petalLength, point1.petalWidth);
        assertEquals(test, point1.toLabel());
    }

    @Test
    void the_to_string_is_correct(){
        IrisPoint point1 = new IrisPoint(1., 1., 1., 1., IrisVariety.SETOSA);
        String result = 1. + " " + 1. + " " + 1. + " " + 1. + " " + "SETOSA";
        assertEquals(result, point1.toString());
    }

}
