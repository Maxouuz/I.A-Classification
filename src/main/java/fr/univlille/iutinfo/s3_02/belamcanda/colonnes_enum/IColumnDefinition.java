package fr.univlille.iutinfo.s3_02.belamcanda.colonnes_enum;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;

public interface IColumnDefinition {
    public Column getColumn();

    public static Column[] getColumns(IColumnDefinition[] definitions){
        int size = definitions.length;
        Column[] res = new Column[size];
        for (int i = 0; i < size; i++) {
            res[i] = definitions[i].getColumn();
        }
        return res;
    }
}
