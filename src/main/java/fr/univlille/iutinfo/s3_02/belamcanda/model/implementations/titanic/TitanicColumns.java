package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.ColumnFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Gender;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.BooleanNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.OrdinalNormalizer;

public enum TitanicColumns implements IColumnDefinition {
    /* TODO Si il y a besoin de normaliser PassengerId, on peut utiliser un NumberColumn, 
     * mais je trouver que ça n'aurait sens
     */
    PASSENGER_ID("passengerId"),
    SURVIVED("survived", new BooleanNormalizer()),
    PCLASS("pClass", new NumberNormalizer()),
    NAME("name"),
    /* TODO vérifier si boolean est correcte pour sex */
    SEX("sex", new OrdinalNormalizer<Gender>()),
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
        this(name, null);
    }

    @Override
    public Column getColumn() {
        return ColumnFactory.createColumn(name, normalizer);
    }
}
