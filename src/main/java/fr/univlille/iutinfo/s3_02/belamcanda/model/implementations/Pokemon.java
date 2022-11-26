package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;

public class Pokemon extends Implementation{
    public Pokemon(Class<? extends Point> point, Class<? extends IColumnDefinition> columns) {
        super(point, columns);
    }


}
