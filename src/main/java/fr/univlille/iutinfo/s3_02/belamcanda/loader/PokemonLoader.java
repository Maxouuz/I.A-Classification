package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.beans.PokemonBean;
import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.point.PokemonPoint;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokemonLoader extends SpecifiedLoader<PokemonBean>{
    @Override
    public boolean dataIsValid(String filePath) {
        return true;
    }

    @Override
    public List<PokemonBean> loadFromFile(String filePath) throws IOException {
        return super.loadFromFile(PokemonBean.class, DATA_DIR + filePath, ',');
    }

    @Override
    public Set<? extends Point> convertToPoints(String filePath) throws IOException {
        List<PokemonBean> list = loadFromFile(filePath);
        Set<PokemonPoint> res = new HashSet<>();
        list.forEach(e -> res.add(new PokemonPoint(e)));
        return res;
    }
}
