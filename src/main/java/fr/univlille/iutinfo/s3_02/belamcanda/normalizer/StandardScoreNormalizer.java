package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import java.util.List;
import java.util.stream.Collectors;

public class StandardScoreNormalizer extends Normalizer {

    public List<Double> normalize(List<? extends Number> values){
        double average = getAverage(values);
        double variance = getVariance(values, average);
        double standardDeviation = Math.sqrt(variance);
        List<Double> normalized = normalizeValues(values, average, standardDeviation);            
        return normalized;       
        
    }

    private static List<Double> normalizeValues(List<? extends Number> values, double average, double standardDeviation) {
        List<Double> normalized = values
            .stream()
            .map(a -> (a.doubleValue() - average) / standardDeviation)
            .collect(Collectors.toList());
        return normalized;
    }

    public static double getVariance(List<? extends Number> values, double average) {
        double variance = values
            .stream()
            .mapToDouble(a -> Math.pow(a.doubleValue() - average, 2))
            .average()
            .getAsDouble();
        return variance;
    }

    public static double getAverage(List<? extends Number> values) {
        double average = values
            .stream()
            .mapToDouble(a -> a.doubleValue())
            .average()
            .getAsDouble();
        return average;
    }

    
}
