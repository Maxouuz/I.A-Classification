package fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.Distance;

import java.util.*;

public class Categorizer {
    private int k;
    private Distance distanceMethod;
    private MVCModel model;

    public Categorizer(MVCModel model, Distance distanceMethod, int k) {
        this.k = k;
        this.distanceMethod = distanceMethod;
        this.model = model;
    }

    public Object categorize(Point toCategorize, Collection<Point> trainingData) {
        Map<Object, Integer> counts = new HashMap<>();
        List<Point> kNN = kNN(toCategorize, trainingData);
        for (Point neighbor: kNN) {
            Object category = neighbor.category();
            counts.putIfAbsent(category, 0);
            int currentPoints = counts.get(category);
            counts.put(category, currentPoints+1);
        }
        return dominantCategory(counts);
    }

    public Object categorize(Point toCategorize){
        return categorize(toCategorize, model.getTrainingData());
    }

    public double getRobustnessByCrossValidation() {
        return new Robustness().crossValidate(this, model.getTrainingData());
    }

    public double getRobustness() {
        if (model.getTestData() == null) return  getRobustnessByCrossValidation();
        return new Robustness().compute(this, model.getTestData(), model.getTrainingData());
    }


    public static Object dominantCategory(Map<Object, Integer> counts) {
        int maxOccurrence = 0;
        Object categoryMostPresent = null;
        for (Object category: counts.keySet()) {
            if (counts.get(category) > maxOccurrence) {
                maxOccurrence = counts.get(category);
                categoryMostPresent = category;
            }
        }
        return categoryMostPresent;
    }

    private List<Point> kNN(Point toCategorize, Collection<Point> trainingData) {
        Map<Double, Point> sortedNeighbors = sortNeighbors(toCategorize, trainingData);
        return sortedNeighbors.values().stream()
                .toList()
                .subList(0, Math.min(k, sortedNeighbors.size()));
    }

    protected Map<Double, Point> sortNeighbors(Point from, Collection<Point> trainingData){
        // La TreeMap trie les éléments dans l'ordre croissant (ce que ne ferais pas une HashMap).
        Map<Double, Point> res = new TreeMap<>();
        for (Point point: model) {
            res.put(distanceMethod.distance(model, point, from), point);
        }
        return res;
    }

    private Map<Double, Point> sortNeighbors(Point toCategorize) {
        return sortNeighbors(toCategorize, model.getTrainingData());
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public Distance getDistanceMethod() {
        return distanceMethod;
    }

    public void setDistanceMethod(Distance distanceMethod) {
        this.distanceMethod = distanceMethod;
    }
}
