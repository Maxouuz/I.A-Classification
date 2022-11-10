package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;

import java.util.List;

public abstract class Point {
    public abstract Object getValue(Column col);
    public Double getNormalizedValue(Column col) {
        return col.getNormalizedValue(this);
    }
}