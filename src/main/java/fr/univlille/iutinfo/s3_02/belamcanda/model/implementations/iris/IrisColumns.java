package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import java.text.Normalizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.BooleanNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NullNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;

public enum IrisColumns implements IColumnDefinition{
    SEPALLENGTH(new NumberColumn("sepalLength")),
    SEPALWIDTH(new NumberColumn("sepalWidth")),
    PETALLENGTH(new NumberColumn("petalLength")),
    PETALWIFTH(new NumberColumn("petalWidth")),
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

