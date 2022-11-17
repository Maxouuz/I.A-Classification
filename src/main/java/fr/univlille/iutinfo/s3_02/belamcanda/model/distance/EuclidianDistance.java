package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

public class EuclidianDistance implements Distance {
    public double distance(MVCModel model, Point p1, Point p2) {
        double sum = 0;
        for (Column column: model.getNormalizableColumns()) {
            sum += Math.pow(column.compare(p1, p2), 2);
        }
        return Math.sqrt(sum);
    }
}
