package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

import java.util.List;

public interface Distance {
    double distance(List<Column> columns, Point p1, Point p2);
}
