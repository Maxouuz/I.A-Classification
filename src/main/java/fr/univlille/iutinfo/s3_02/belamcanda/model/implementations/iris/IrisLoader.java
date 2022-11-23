package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.SpecifiedLoader;

import java.io.IOException;
import java.util.List;

public class IrisLoader extends SpecifiedLoader {
    @Override
    public boolean dataIsValid(String filePath) {
        return true;
    }

    @Override
    public List<Point> loadFromFile(String filePath) throws IOException {
        return super.loadFromFile(IrisPoint.class, filePath, ',');
    }

    @Override
    protected MVCModel createModel() {
        return new IrisModel();
    }
}
