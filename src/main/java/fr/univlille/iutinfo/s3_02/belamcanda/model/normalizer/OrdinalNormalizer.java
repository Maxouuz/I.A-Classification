package fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer;

import fr.univlille.iutinfo.s3_02.belamcanda.model.ColumnComparator;
import fr.univlille.iutinfo.s3_02.belamcanda.model.DrasticComparator;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;

public abstract class OrdinalNormalizer implements IValueNormalizer {
    @Override
    public abstract double normalize(Object value, Amplitude amplitude);

    protected double normalize(double ordinal, int enumLength){
        return ordinal / (enumLength - 1);
    }

    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean needAmplitude() {
        return false;
    }

    @Override
    public ColumnComparator getComparator() {
        return new DrasticComparator();
    }

    public static void main(String[] args) {
        Object o = Legendary.FALSE;
        System.out.println(o.getClass());
    }
}
