package fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategorizerTest {

    @Test
    void dominant_category_ts_the_return_category(){
        Map<Object, Integer> map = new HashMap<>();
        map.put(0.,0);
        map.put(1.,1);
        map.put(2.,2);

        assertEquals(2., Categorizer.dominantCategory(map));

        map.put(3.,3);

        assertEquals(3., Categorizer.dominantCategory(map));
    }


}
