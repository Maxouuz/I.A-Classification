package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicPoint;

public enum CSVModel {
    POKEMON(PokemonPoint.class, new PokemonModel(),','),
    TITANIC(TitanicPoint.class, new TitanicModel(), ','),
    IRIS(IrisPoint.class, new PokemonModel(), ',');

    private Class<? extends Point> clazz;
    private MVCModel model;
    private char separator;

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
}
