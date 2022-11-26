package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;

public abstract class Implementation {
    Class<? extends Point> point;
    Class<? extends IColumnDefinition> columns;

    public Implementation(Class<? extends Point> point, Class<? extends IColumnDefinition> columns) {
        this.point = point;
        this.columns = columns;
    }

    public Column[] columns(){return IColumnDefinition.getColumns(columns.getEnumConstants());}
}
