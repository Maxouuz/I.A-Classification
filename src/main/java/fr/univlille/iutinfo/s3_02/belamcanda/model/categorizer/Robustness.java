package fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

import java.util.*;

public class Robustness {
    Double compute(Categorizer categorizer, Collection<Point> testData, Collection<Point> trainingData) {
        Map<Point, Object> categorized = categorize(categorizer, testData, trainingData);
        return computeSuccessRate(categorized);
    }

    Map<Point, Object> categorize(Categorizer categorizer, Collection<Point> testData, Collection<Point> trainingData) {
        Map<Point, Object> res = new HashMap<>();
        for (Point point : testData) {
            res.put(point, categorizer.categorize(point, trainingData));
        }
        return res;
    }

    Double computeSuccessRate(Map<Point, Object> categorized) {
        return categorized.entrySet().stream()
                .mapToDouble(e -> e.getKey().category().equals(e.getValue()) ? 1 : 0)
                .average().getAsDouble();
    }


    public Double crossValidate(Categorizer categorizer, Collection<Point> trainingData) {
        List<List<Point>> fifths = splitData(trainingData);
        Collection<Point> makeShiftTrainingData;
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            makeShiftTrainingData = extractTrainingData(fifths, i);
            sum += compute(categorizer, fifths.get(i), makeShiftTrainingData);
        }
        return sum / 5.0;
    }

    private static Collection<Point> extractTrainingData(List<List<Point>> fifths, int i) {
        Collection<Point> trainingData;
        trainingData = new ArrayList<>();
        for (int j = 1; j < 5; j++) {
            trainingData.addAll(fifths.get((i + j) % 5));
        }
        return trainingData;
    }

    public List<List<Point>> splitData(Collection<Point> points) {
        List<List<Point>> res = new ArrayList<>();
        List<Point> list = new ArrayList<>(points);
        Collections.shuffle(list);
        int size = list.size();
        int fifth = size / 5;
        for (int i = 0; i < 5; i++) {
            res.add(list.subList(i * fifth, (1 + i) * fifth));
        }
        return res;
    }
}
