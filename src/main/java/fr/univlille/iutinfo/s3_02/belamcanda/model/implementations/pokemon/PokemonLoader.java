package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.SpecifiedLoader;

import java.io.IOException;
import java.util.List;

public class PokemonLoader extends SpecifiedLoader<PokemonPoint> {
    @Override
    public boolean dataIsValid(String filePath) {
        return true;
    }

    @Override
    public List<PokemonPoint> loadFromFile(String filePath) throws IOException {
        return super.loadFromFile(PokemonPoint.class, filePath, ',');
    }

    @Override
    protected MVCModel createModel() {
        return new PokemonModel();
    }
}
