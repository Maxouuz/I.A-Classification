package fr.univlille.iutinfo.s3_02.belamcanda.point;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.PokemonBean;

public class PokemonPoint extends Point{
    PokemonBean bean;
    public PokemonPoint(PokemonBean bean) {
        super(bean);
    }

    @Override
    public Object getValue(Column col) {
        return null;
    }
}
