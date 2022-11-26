package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicPoint;

public enum CSVModel {
    POKEMON(PokemonPoint.class, new PokemonModel(), ','),
    TITANIC(TitanicPoint.class, new TitanicModel(), ','),
    IRIS(IrisPoint.class, new IrisModel(), ',');

    private final Class<? extends Point> clazz;
    private final MVCModel model;
    private final char separator;

    CSVModel(Class<? extends Point> clazz, MVCModel model, char separator) {
        this.clazz = clazz;
        this.model = model;
        this.separator = separator;
    }

    public Class<? extends Point> getClazz() {
        return clazz;
    }

    public MVCModel getModel() {
        return model;
    }

    public char getSeparator() {
        return separator;
    }

    public static CSVModel fromClazz(Class<? extends Point> clazz) {
        for (CSVModel m : values()) {
            if (clazz.equals(m.getClazz())) return m;
        }
        return null;
    }
}
