package fr.univlille.iutinfo.s3_02.belamcanda.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;

import java.util.List;

public interface Distance {

    /*public Double distance(Point p1, Point p2){
        final Map<String, Double> o = other.getNormalizedScores();
        return point.getNormalizedScores().entrySet()
            .stream()
            .mapToDouble(
                e -> distance(e.getValue(), o.get(e.getKey())) * (weights == null ? 1 : weights.get(e.getKey()))).sum();
    }



    protected abstract double distance(Number n1, Number n2);
    */

    public double distance(List<Column> columns, Point p1, Point p2);
}
