package fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

import java.util.*;

public class Robustness {
    Double compute(Categorizer categorizer, Collection<Point> testData, Collection<Point> trainingData) {
        return testData.stream()
                .mapToDouble(point -> wellCategorized(categorizer, point, trainingData))
                .average().getAsDouble();
    }

    private int wellCategorized(Categorizer categorizer, Point point, Collection<Point> trainingData) {
        return categorizer.categorize(point, trainingData).equals(point.category()) ? 1 : 0;
    }

    public Double crossValidate(Categorizer categorizer, Collection<Point> trainingData){
        List<List<Point>> fifths = splitData(trainingData);
        Collection<Point> makeShifTrainingData;
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            makeShifTrainingData = extractTrainingData(fifths, i);
            sum += compute(categorizer, fifths.get(i), makeShifTrainingData);
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

    public List<List<Point>> splitData(Collection<Point> points){
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
