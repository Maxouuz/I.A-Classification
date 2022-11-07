package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.category.ICategory;

public abstract class Point{
    public abstract Object getValue(Column col);
    public Double getNormalizedValue(Column col){
        if (col.isNormalizable()) return col.getNormalizedValue(this);
        return 0.;
    }
    public abstract ICategory getCategory();
}