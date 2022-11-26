package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

public class ManhattanDistance implements Distance {
    public double distance(MVCModel model, Point p1, Point p2) {
        double sum = 0;
        for (Column column: model.getUsedColumns()) {
            sum += column.compare(p1, p2) * column.getWeight();
        }
        return sum;
    }
}
