package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;

public interface IColumnDefinition {
    Column getColumn();

    static Column[] getColumns(IColumnDefinition[] definitions){
        int size = definitions.length;
        Column[] res = new Column[size];
        for (int i = 0; i < size; i++) {
            res[i] = definitions[i].getColumn();
        }
        return res;
    }
}
