package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.SpecifiedLoader;

import java.io.IOException;
import java.util.List;

public class TitanicLoader extends SpecifiedLoader<TitanicPoint> {
    @Override
    public boolean dataIsValid(String filePath) {
        return true;
    }

    @Override
    public List<TitanicPoint> loadFromFile(String filePath) throws IOException {
        return super.loadFromFile(TitanicPoint.class, filePath, ',');
    }
}
