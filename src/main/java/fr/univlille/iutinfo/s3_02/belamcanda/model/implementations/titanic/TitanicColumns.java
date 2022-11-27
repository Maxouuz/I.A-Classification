package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.ColumnFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.BooleanNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;

public enum TitanicColumns implements IColumnDefinition {
    /* TODO Si il y a besoin de normaliser PassengerId, on peut utiliser un NumberColumn, 
     * mais je trouver que ça n'aurait sens
     */
    PASSENGER_ID("passengerId"),
    SURVIVED("survived", new BooleanNormalizer()),
    PCLASS("pClass", new NumberNormalizer()),
    NAME("name"),
    /* TODO vérifier si boolean est correcte pour sex */
    SEX("sex", new BooleanNormalizer()),
    AGE("age", new NumberNormalizer()),
    SIBSP("sibSp", new NumberNormalizer()),
    PARCH("parch", new NumberNormalizer()),
    TICKET("ticket"),
    FARE("fare"),
    CABIN("cabin"),
    /* TODO vérifier si il peut etre normaliser */
    EMBARKED("embarked");

    final String name;
    final IValueNormalizer normalizer;

    TitanicColumns(String name, IValueNormalizer normalizer) {
        this.name = name;
        this.normalizer = normalizer;
    }

    TitanicColumns(String name) {
        this.name = name;
        this.normalizer = null;
    }

    @Override
    public Column getColumn() {
        return ColumnFactory.createColumn(name, normalizer);
    }
}
