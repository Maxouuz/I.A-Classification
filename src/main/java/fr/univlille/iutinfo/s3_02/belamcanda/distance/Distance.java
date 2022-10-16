package fr.univlille.iutinfo.s3_02.belamcanda.distance;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public abstract class Distance {
    //TODO remplacer object par le type de données créé
    public Map<TempObject, Double> distances(TempObject point, List<TempObject> cloud){
        return privateDistances(point, cloud, null);
    }

    public Map<TempObject, Double> weightedDistances(TempObject point, List<TempObject> cloud, Map<String, Double> weights){
        return privateDistances(point, cloud, weights);
    }   

    private Map<TempObject, Double> privateDistances(TempObject point, List<TempObject> cloud, Map<String, Double> weights){
        Map<TempObject, Double> distances = cloud
            .stream()
            .collect(Collectors.toMap(o -> o, o -> distance(point, o, weights)));
        return distances;
    }

    public Double distance(TempObject point, TempObject other, Map<String, Double> weights){
        Double sum = 0.0;
        Map<String, Double> o = other.getNormalizedScores();
        for (Entry<String, Double> e : point.getNormalizedScores().entrySet()) {
            sum += distance(e.getValue(), o.get(e.getKey())) * (weights == null ? 1 : weights.get(e.getKey()));
        }
        return sum;
    }

    protected abstract double distance(Number n1, Number n2);
}
