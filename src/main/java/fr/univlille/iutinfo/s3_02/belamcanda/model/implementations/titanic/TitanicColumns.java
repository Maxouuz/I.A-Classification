package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

public enum TitanicColumns implements IColumnDefinition {
    /* TODO Si il y a besoin de normaliser PassengerId, on peut utiliser un NumberColumn, 
     * mais je trouver que ça n'aurait sens
     */
    PASSENGER_ID(new NonNormalizableColumn("passengerId")),
    SURVIVED(new BooleanColumn("survived")),
    PCLASS(new NumberColumn("pClass")),
    NAME(new NonNormalizableColumn("name")),
    /* TODO vérifier si boolean est correcte pour sex */
    SEX(new BooleanColumn("sex")),
    AGE(new NumberColumn("age")),
    SIBSP(new NumberColumn("sibSp")),
    PARCH(new NumberColumn("parch")),
    TICKET(new NonNormalizableColumn("ticket")),
    FARE(new NumberColumn("fare")),
    CABIN(new NonNormalizableColumn("cabin")),
    /* TODO vérifier si il peut etre normaliser */
    EMBARKED(new NonNormalizableColumn("embarked"));

    final Column column;

    TitanicColumns(Column column) {
        this.column = column;
    }

    @Override
    public Column getColumn() {
        return this.column;
    }
}
