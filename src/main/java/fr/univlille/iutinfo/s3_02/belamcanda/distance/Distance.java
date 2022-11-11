package fr.univlille.iutinfo.s3_02.belamcanda.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.Point;

import java.util.List;

public interface Distance {
    public double distance(List<Column> columns, Point p1, Point p2);
}
