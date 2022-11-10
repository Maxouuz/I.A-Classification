package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.IrisBean;

public class IrisPoint extends Point{

    public IrisPoint(IrisBean bean) {
        super(bean);
    }

    @Override
    public Object getValue(Column col) {
        return null;
    }
}
