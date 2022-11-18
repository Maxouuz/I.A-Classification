package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.ColumnFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.NonNormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

public enum TitanicColumns implements IColumnDefinition {
    /* TODO Si il y a besoin de normaliser PassengerId, on peut utiliser un NumberColumn, 
     * mais je trouver que ça n'aurait sens
     */
    PASSENGER_ID(new NonNormalizableColumn("passengerId")),
    SURVIVED(ColumnFactory.booleanColumn("survived")),
    PCLASS(ColumnFactory.numberColumn("pClass")),
    NAME(new NonNormalizableColumn("name")),
    /* TODO vérifier si boolean est correcte pour sex */
    SEX(ColumnFactory.booleanColumn("sex")),
    AGE(ColumnFactory.numberColumn("age")),
    SIBSP(ColumnFactory.numberColumn("sibSp")),
    PARCH(ColumnFactory.numberColumn("parch")),
    TICKET(new NonNormalizableColumn("ticket")),
    FARE(ColumnFactory.numberColumn("fare")),
    CABIN(new NonNormalizableColumn("cabin")),
    /* TODO vérifier si il peut etre normaliser */
    EMBARKED(new NonNormalizableColumn("embarked"));

    private final Column column;

    TitanicColumns(Column column) {
        this.column = column;
    }

    @Override
    public Column getColumn() {
        return this.column;
    }
}
