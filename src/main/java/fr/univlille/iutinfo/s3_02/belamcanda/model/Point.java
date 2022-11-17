package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

import java.lang.reflect.Field;

public abstract class Point {
    public Object getValueFromString(String attrName) throws NoSuchFieldException, IllegalAccessException {
        Field field = getClass().getDeclaredField(attrName);
        // Si la classe implémentée est dans un autre paquet, on est obligé d'écrire la ligne ci-dessous
        field.setAccessible(true);
        return field.get(this);
    }

    public Object getValue(Column col) {
        try{
            Object val = getValueFromString(col.getName());
            if (val != null) return val;
            return new NullObject();
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
}
