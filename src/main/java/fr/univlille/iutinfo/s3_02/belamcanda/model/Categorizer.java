package fr.univlille.iutinfo.s3_02.belamcanda.model;

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

    public Object categorize(Point toCategorize) {
        Map<Object, Integer> nbPointsByCategory = new HashMap<>();
        for (Point neighbor: getNearestNeighbors(toCategorize)) {
            Object category = neighbor.category();
            nbPointsByCategory.putIfAbsent(category, 0);
            int currentPoints = nbPointsByCategory.get(category);
            nbPointsByCategory.put(category, currentPoints+1);
        }
        return getCategoryMostPresent(nbPointsByCategory);
    }

    public double getRobustness() {
        int acc = 0;
        int total = 0;
        for (Point point: model.getDataToClassify()) {
            if (categorize(point).equals(point.category())) {
                acc += 1;
            }
            total++;
        }
        return acc * 100.0 / total;
    }

    private Object getCategoryMostPresent(Map<Object, Integer> nbPointsByCategory) {
        int maxOccurrence = 0;
        Object categoryMostPresent = null;
        for (Object category: nbPointsByCategory.keySet()) {
            if (nbPointsByCategory.get(category) > maxOccurrence) {
                maxOccurrence = nbPointsByCategory.get(category);
                categoryMostPresent = category;
            }
        }
        return categoryMostPresent;
    }

    public List<Point> getNearestNeighbors(Point toCategorize) {
        Map<Double, Point> nearestNeighbors = computeDistanceWithAllThePoints(toCategorize);
        return keepOnlyKNearestNeighbors(nearestNeighbors);
    }

    private List<Point> keepOnlyKNearestNeighbors(Map<Double, Point> nearestNeighbors) {
        return nearestNeighbors.values().stream()
                .toList()
                .subList(0, Math.min(k, nearestNeighbors.size()));
    }

    private Map<Double, Point> computeDistanceWithAllThePoints(Point toCategorize) {
        // La TreeMap trie les éléments dans l'ordre croissant (ce que ne ferais pas une HashMap).
        Map<Double, Point> nearestNeighbors = new TreeMap<>();
        for (Point point: model) {
            nearestNeighbors.put(distanceMethod.distance(model, point, toCategorize), point);
        }
        return nearestNeighbors;
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
