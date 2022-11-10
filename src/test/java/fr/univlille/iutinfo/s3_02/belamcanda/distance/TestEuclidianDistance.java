package fr.univlille.iutinfo.s3_02.belamcanda.distance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestEuclidianDistance {
    static double DELTA = 0.005;

    @BeforeAll
    public static void init_points(){
        
    } 
/**
    @Test
    @Disabled
    public void object_one_unit_away_should_be_at_distance_one() {
        TempObject o0 = new TempObject(0, 0, 0, 0);
        TempObject o1 = new TempObject(1, 0, 0, 0);
        TempObject o2 = new TempObject(0, 1, 0, 0);
        TempObject o3 = new TempObject(0, 0, 1, 0);
        TempObject o4 = new TempObject(0, 0, 0, 1);
        
        assertEquals(1, new EuclidianDistance().distance(o0, o1, null), DELTA);
        assertEquals(1, new EuclidianDistance().distance(o0, o2, null), DELTA);
        assertEquals(1, new EuclidianDistance().distance(o0, o3, null), DELTA);
        assertEquals(1, new EuclidianDistance().distance(o0, o4, null), DELTA);
    }

    @Test
    public void object_with_weighted_distance() {
        Map<String, Double> weights = new HashMap<>();
        weights.put("Tennis", 0.);
        weights.put("Foot", .5);
        weights.put("Ping", 1.);
        weights.put("Golf", 2.);


        TempObject o0 = new TempObject(0, 0, 0, 0);
        TempObject o1 = new TempObject(1, 0, 0, 0);
        TempObject o2 = new TempObject(0, 1, 0, 0);
        TempObject o3 = new TempObject(0, 0, 1, 0);
        TempObject o4 = new TempObject(0, 0, 0, 1);
        TempObject o5 = new TempObject(1, 1, 1, 1);
        
        assertEquals(0, new EuclidianDistance().distance(o0, o1, weights), DELTA);
        assertEquals(.5, new EuclidianDistance().distance(o0, o2, weights), DELTA);
        assertEquals(1, new EuclidianDistance().distance(o0, o3, weights), DELTA);
        assertEquals(2, new EuclidianDistance().distance(o0, o4, weights), DELTA);
        assertEquals(0 + .5 + 1 + 2, new EuclidianDistance().distance(o0, o5, weights), DELTA);
    }*/
}
