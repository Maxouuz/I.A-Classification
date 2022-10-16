package fr.univlille.iutinfo.s3_02.belamcanda.distance;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestManhattanDistance {
    static double DELTA = 0.005;

    /**
     * Test d'une propriété de la distance de manhattan. Pour plus d'informations, voir cette page:
     * <a href="https://fr.wikipedia.org/wiki/Distance_de_Manhattan#Propriétés">Propriétés distance de manhattan</a>
     */
    @Test
    public void test_distance_between_two_objects_equals_to_sum_of_axes_displacements() {

        TempObject o0 = new TempObject(0, 0, 0, 0);
        TempObject o1 = new TempObject(1, 0, 0, 0);
        TempObject o2 = new TempObject(1, 1, 0, 0);
        TempObject o3 = new TempObject(0, 0, 2, 2);
        TempObject o4 = new TempObject(0, 3, 3, 3);
        TempObject o5 = new TempObject(4, 4, 4, 4);

        assertEquals(1, new ManhattanDistance().distance(o0, o1, null), DELTA);
        assertEquals(1+1, new ManhattanDistance().distance(o0, o2, null), DELTA);
        assertEquals(2+2, new ManhattanDistance().distance(o0, o3, null), DELTA);
        assertEquals(3+3+3, new ManhattanDistance().distance(o0, o4, null), DELTA);
        assertEquals(4+4+4+4, new ManhattanDistance().distance(o0, o5, null), DELTA);
    }

    @Test
    public void object_with_weighted_distance() {
        Map<String, Double> weights = new HashMap<>();
        weights.put("Tennis", 0.);
        weights.put("Foot", .5);
        weights.put("Ping", 1.);
        weights.put("Golf", 2.);

        TempObject o0 = new TempObject(0, 0, 0, 0);
        TempObject o1 = new TempObject(1, 1, 0, 0);
        TempObject o2 = new TempObject(0, 1, 1, 0);
        TempObject o3 = new TempObject(0, 0, 2, 2);
        TempObject o4 = new TempObject(0, 3, 3, 3);
        TempObject o5 = new TempObject(4, 4, 4, 4);

        assertEquals(.5, new ManhattanDistance().distance(o0, o1, weights), DELTA);
        assertEquals(.5 + 1., new ManhattanDistance().distance(o0, o2, weights), DELTA);
        assertEquals(2 + 4, new ManhattanDistance().distance(o0, o3, weights), DELTA);
        assertEquals(1.5 + 3 + 6, new ManhattanDistance().distance(o0, o4, weights), DELTA);
        assertEquals(0 + 2 + 4 + 8, new ManhattanDistance().distance(o0, o5, weights), DELTA);
    }
}
