package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

public enum IrisColumns implements IColumnDefinition{
    SEPAL_LENGTH(new NumberColumn("sepalLength")),
    SEPAL_WIDTH(new NumberColumn("sepalWidth")),
    PETAL_LENGTH(new NumberColumn("petalLength")),
    PETAL_WIDTH(new NumberColumn("petalWidth")),
    VARIETY(new NonNormalizableColumn("Variety"));

    final Column column;

    IrisColumns(Column column) {
        this.column = column;
    }

    @Override
    public Column getColumn() {
        return this.column;
    }
}

