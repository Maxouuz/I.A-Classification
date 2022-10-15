package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import java.util.List;
import java.util.stream.Collectors;

public class MinMaxNormalizer extends Normalizer {
    @Override
    public List<Double> normalize(List<? extends Number> values) {
        Double min = getMin(values);
        Double max = getMax(values);
        List<Double> normalized = normalizeValues(values, min, max);
        return normalized;
    }

    public static Double getMin(List<? extends Number> values) {
        Double min = values
            .stream()
            .mapToDouble(a -> a.doubleValue())
            .min()
            .getAsDouble();
        return min;
    }

    public static Double getMax(List<? extends Number> values) {
        Double max = values
            .stream()
            .mapToDouble(a -> a.doubleValue())
            .max()
            .getAsDouble();
        return max;
    }

    private static List<Double> normalizeValues(List<? extends Number> values, Double min, Double max) {        
        Double delta = max - min;
        List<Double> normalized = values
            .stream()
            .map(a -> (a.doubleValue() - min) / delta)
            .collect(Collectors.toList());
        return normalized;
    }
    
}
