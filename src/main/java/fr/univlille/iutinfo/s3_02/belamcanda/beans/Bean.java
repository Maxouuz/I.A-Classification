package fr.univlille.iutinfo.s3_02.belamcanda.beans;

import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;

public abstract class Bean<T extends Point> {
    public abstract T toPoint();
}
