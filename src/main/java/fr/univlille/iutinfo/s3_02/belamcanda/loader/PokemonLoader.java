package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.beans.PokemonPoint;

import java.io.IOException;
import java.util.List;

public class PokemonLoader extends SpecifiedLoader<PokemonPoint>{
    @Override
    public boolean dataIsValid(String filePath) {
        return true;
    }

    @Override
    public List<PokemonPoint> loadFromFile(String filePath) throws IOException {
        return super.loadFromFile(PokemonPoint.class, filePath, ',');
    }
}
