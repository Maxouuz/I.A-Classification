package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;

public enum IrisColumns implements IColumnDefinition {
    SEPAL_LENGTH("sepalLength", new NumberNormalizer()),
    SEPAL_WIDTH("sepalWidth", new NumberNormalizer()),
    PETAL_LENGTH("petalLength", new NumberNormalizer()),
    PETAL_WIDTH("petalWidth", new NumberNormalizer()),
    VARIETY("variety");

    final String name;
    final IValueNormalizer normalizer;

    IrisColumns(String name, IValueNormalizer normalizer) {
        this.name = name;
        this.normalizer = normalizer;
    }

    IrisColumns(String name) {
        this.name = name;
        this.normalizer = null;
    }

    @Override
    public Column getColumn() {
        return ColumnFactory.createColumn(name, normalizer);
    }
}

