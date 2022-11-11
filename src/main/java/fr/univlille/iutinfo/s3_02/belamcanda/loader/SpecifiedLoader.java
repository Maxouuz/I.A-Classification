package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.beans.Bean;
import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class SpecifiedLoader<T> extends CSVLoader{
    public abstract boolean dataIsValid(String filePath);

    public Set<? extends Point> loadPoints(String filePath) throws Exception {
        if (!dataIsValid(filePath)) throw new Exception("Mauvais format de fichier !");
        return convertToPoints(filePath);
    }

    public abstract List<? extends Bean> loadFromFile(String filePath) throws IOException;

    public Set<? extends Point> convertToPoints(String filePath) throws IOException{
        List<? extends Bean> list = loadFromFile(filePath);
        Set<Point> res = new HashSet<>();
        list.forEach(bean -> res.add(bean.toPoint()));
        return res;
    }

}
