package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.NormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisPoint;

public class TitanicModel extends MVCModel {
    public TitanicModel() {
        super(IrisPoint.class);
    }

    @Override
    public String getTitle() {
        return "Titanic";
    }

    @Override
    public Column[] getColumns() {
        return IColumnDefinition.getColumns(TitanicColumns.values());
    }

    @Override
    public NormalizableColumn defaultXCol() {
        return (NormalizableColumn)TitanicColumns.SURVIVED.getColumn();
    }

    @Override
    public Column defaultYCol() {
        return (NormalizableColumn)TitanicColumns.AGE.getColumn();
    }
}
