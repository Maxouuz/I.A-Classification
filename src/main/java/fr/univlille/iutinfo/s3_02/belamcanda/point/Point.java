package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.Bean;

import java.util.List;

public abstract class Point {
    protected Bean bean;

    protected Point(Bean bean){this.bean = bean;}
    public abstract Object getValue(Column col);
    public Double getNormalizedValue(Column col) {
        return col.getNormalizedValue(this);
    }
}