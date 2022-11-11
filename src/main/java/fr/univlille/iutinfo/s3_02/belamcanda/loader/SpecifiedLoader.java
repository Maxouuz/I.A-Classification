package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.beans.Point;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class SpecifiedLoader<T> extends CSVLoader{
    public abstract boolean dataIsValid(String filePath);

    public Set<? extends Point> loadPoints(String filePath) throws Exception {
        if (!dataIsValid(filePath)) throw new Exception("Mauvais format de fichier !");
        return new HashSet<>(loadFromFile(filePath));
    }

    public abstract List<? extends Point> loadFromFile(String filePath) throws IOException;



}
