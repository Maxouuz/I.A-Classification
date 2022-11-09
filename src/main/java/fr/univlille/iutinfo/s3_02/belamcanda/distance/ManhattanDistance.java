package fr.univlille.iutinfo.s3_02.belamcanda.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;

import java.util.List;

public class ManhattanDistance implements Distance {
    public double distance(List<Column> columns, Point p1, Point p2) {
        double sum = 0;
        for (Column column: columns) {
            sum += Math.abs(column.getNormalizedValue(p1) - column.getNormalizedValue(p2));
        }
        return sum;
    }
}
