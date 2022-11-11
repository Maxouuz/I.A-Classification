package fr.univlille.iutinfo.s3_02.belamcanda.beans;

import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;

import java.lang.reflect.Field;

public abstract class Bean<T extends Point> {
    public abstract T toPoint();

    public Object getValueFromString(String attrName) throws NoSuchFieldException, IllegalAccessException {
        Field field = this.getClass().getDeclaredField(attrName);
        return field.get(this);
    }
}
