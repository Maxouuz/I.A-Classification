package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes;

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
