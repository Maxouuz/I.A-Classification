package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.BooleanNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NullNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;

public enum TitanicColumns implements IColumnDefinition {
    /* TODO Si il y a besoin de normaliser PassengerId, on peut utiliser un NumberColumn, 
     * mais je trouver que ça n'aurait sens
     */
    PASSERGERID(new NonNormalizableColumn("PassengerId")),
    SURVIVED(new BooleanColumn("Survived")),
    PCLASS(new NumberColumn("Pclass")),
    NAME(new NonNormalizableColumn("Name")),
    /* TODO vérifier si boolean est correcte pour sex */
    SEX(new BooleanColumn("Sex")),
    AGE(new NumberColumn("Age")),
    SIBSP(new NumberColumn("SibSp")),
    PARCH(new NumberColumn("Parch")),
    TICKET(new NonNormalizableColumn("Ticket")),
    FARE(new NumberColumn("Fare")),
    CABIN(new NonNormalizableColumn("Cabin")),
    /* TODO vérifier si il peut etre normaliser */
    EMBARKED(new NonNormalizableColumn("Embarked"));

    final Column column;

    TitanicColumns(Column column) {
        this.column = column;
    }

    @Override
    public Column getColumn() {
        return this.column;
    }
}
