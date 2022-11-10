package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.TitanicBean;

public class TitanicPoint extends Point{
    public TitanicPoint(TitanicBean bean){super(bean);}
    @Override
    public Object getValue(Column col) {
        return null;
    }
}
