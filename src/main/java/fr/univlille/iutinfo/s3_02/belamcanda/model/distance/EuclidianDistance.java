package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

import java.util.List;

public class EuclidianDistance implements Distance {
    public double distance(List<Column> columns, Point p1, Point p2) {
        double sum = 0;
        for (Column column: columns) {
            sum += Math.pow(column.getNormalizedValue(p1) - column.getNormalizedValue(p2), 2);
        }
        return Math.sqrt(sum);
    }
}
