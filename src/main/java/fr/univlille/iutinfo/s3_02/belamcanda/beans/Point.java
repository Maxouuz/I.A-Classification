package fr.univlille.iutinfo.s3_02.belamcanda.beans;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;

import java.lang.reflect.Field;

public abstract class Point {

    public Object getValueFromString(String attrName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(attrName);
        return field.get(this);
    }

    public Object getValue(Column col) {
        try{
            return getValueFromString(col.getName());
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
