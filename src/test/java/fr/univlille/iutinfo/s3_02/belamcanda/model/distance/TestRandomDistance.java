package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestRandomDistance {
    @Test
    void random_distance_is_called_random(){
        RandomDistance distance = new RandomDistance();
        assertEquals("Aléatoire", distance.toString());
    }
}
