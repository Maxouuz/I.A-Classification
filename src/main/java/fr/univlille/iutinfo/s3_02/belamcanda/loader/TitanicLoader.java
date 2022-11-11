package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.beans.TitanicBean;
import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.point.TitanicPoint;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TitanicLoader extends SpecifiedLoader<TitanicBean> {
    @Override
    public boolean dataIsValid(String filePath) {
        return true;
    }

    @Override
    public List<TitanicBean> loadFromFile(String filePath) throws IOException {
        return super.loadFromFile(TitanicBean.class, filePath, ',');
    }
}
