package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.Bean;

import java.lang.reflect.Field;
import java.util.List;

public abstract class Point {
    protected Bean bean;

    protected Point(Bean bean){this.bean = bean;}
    public Object getValue(Column col) {
        try{
            return bean.getValueFromString(col.getName());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public Double getNormalizedValue(Column col){
        return col.getNormalizedValue(this);
    }
}