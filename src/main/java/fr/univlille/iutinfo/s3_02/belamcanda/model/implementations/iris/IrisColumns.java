package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import fr.univlille.iutinfo.s3_02.belamcanda.ColumnFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

public enum IrisColumns implements IColumnDefinition{
    SEPAL_LENGTH(ColumnFactory.numberColumn("sepalLength")),
    SEPAL_WIDTH(ColumnFactory.numberColumn("sepalWidth")),
    PETAL_LENGTH(ColumnFactory.numberColumn("petalLength")),
    PETAL_WIDTH(ColumnFactory.numberColumn("petalWidth")),
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

