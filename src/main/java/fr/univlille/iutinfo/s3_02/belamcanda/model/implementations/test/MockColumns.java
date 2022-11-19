package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.test;

import fr.univlille.iutinfo.s3_02.belamcanda.ColumnFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.NonNormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

public enum MockColumns implements IColumnDefinition {
    NAME(new NonNormalizableColumn("name")),
    AGE(ColumnFactory.numberColumn("age")),
    SHOE_SIZE(ColumnFactory.numberColumn("shoeSize")),
    IS_RELIGIOUS(ColumnFactory.booleanColumn("isReligious"));

    private final Column column;

    MockColumns(Column column) {
        this.column = column;
    }

    @Override
    public Column getColumn() {
        return this.column;
    }
}
