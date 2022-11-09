package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.category.ICategory;

public abstract class Point{
    public abstract Object getValue(Column col);
    public Double getNormalizedValue(Column col){
        return col.getNormalizedValue(this);
    }
    public abstract ICategory getCategory();
}