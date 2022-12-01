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

    public String getStringValue(Column col) {
        Object val = getValue(col);
        if (val != null) return val.toString();
        return null;
    }

    private Field categoryField() {
        Field[] fields = getClass().getFields();
        return fields[fields.length - 1];
    }

    public Object category() {
        try {
            return categoryField().get(this);
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public void setCategory(Object value) {
        try {
            categoryField().set(this, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract String toLabel();

    @Override
    public abstract String toString();

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);
}
