package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

import java.util.Random;

public class RandomDistance implements Distance{
    Random rng = new Random();
    @Override
    public double distance(MVCModel model, Point p1, Point p2) {
        return rng.nextDouble();
    }

    @Override
    public String toString() {
        return "Aléatoire";
    }
}
