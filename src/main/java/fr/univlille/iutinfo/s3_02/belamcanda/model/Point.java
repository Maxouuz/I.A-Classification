package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;

import java.lang.reflect.Field;

public abstract class Point {
    protected Object getValueFromString(String attrName) throws NoSuchFieldException, IllegalAccessException {
        Field field = getClass().getDeclaredField(attrName);
        // Si la classe implémentée est dans un autre paquet, on est obligé d'écrire la ligne ci-dessous
        field.setAccessible(true);
        return field.get(this);
    }

    public Object getValue(Column col) {
        try{
            return getValueFromString(col.getName());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Object category();

    public Double getNormalizedValue(Column col){
        return col.getNormalizedValue(this);
    }

    public String getStringValue(Column col) {
        Object val = getValue(col);
        if (val != null) return val.toString();
        return null;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);
}
