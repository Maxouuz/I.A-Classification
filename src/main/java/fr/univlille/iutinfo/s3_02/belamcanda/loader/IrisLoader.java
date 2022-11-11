package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.beans.IrisBean;
import fr.univlille.iutinfo.s3_02.belamcanda.point.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IrisLoader extends SpecifiedLoader<IrisBean>{
    @Override
    public boolean dataIsValid(String filePath) {
        return true;
    }

    @Override
    public List<IrisBean> loadFromFile(String filePath) throws IOException {
        return super.loadFromFile(IrisBean.class, filePath, ',');
    }
}
