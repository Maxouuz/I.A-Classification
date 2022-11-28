package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.TitanicPoint;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public enum CSVModel {
    POKEMON(PokemonPoint.class, PokemonModel.class, ','),
    TITANIC(TitanicPoint.class, TitanicModel.class, ','),
    IRIS(IrisPoint.class, IrisModel.class, ',');

    private final Class<? extends Point> clazz;
    private final Class<? extends MVCModel> modelClass;
    private final char separator;

    CSVModel(Class<? extends Point> clazz, Class<? extends MVCModel> modelClass, char separator) {
        this.clazz = clazz;
        this.modelClass = modelClass;
        this.separator = separator;
    }

    public Class<? extends Point> getClazz() {
        return clazz;
    }

    public MVCModel getModel() {
        try {
            Constructor<?> ctor = modelClass.getConstructor();
            return (MVCModel) ctor.newInstance();
        } catch (ReflectiveOperationException e) {
            return null;
        }
    }

    public char getSeparator() {
        return separator;
    }

    public List<String> getColumnsName() {
        List<String> columns = new ArrayList<>();
        for (Field f: getClazz().getDeclaredFields()) {
            CsvBindByName column = f.getAnnotation(CsvBindByName.class);
            if (column != null) {
                columns.add(column.column());
            }
        }
        return columns;
    }
}
