package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.IrisBean;

public class IrisPoint extends Point{
    IrisBean bean;

    public IrisPoint(IrisBean bean) {
        this.bean = bean;
    }

    @Override
    public Object getValue(Column col) {
        return null;
    }
}
