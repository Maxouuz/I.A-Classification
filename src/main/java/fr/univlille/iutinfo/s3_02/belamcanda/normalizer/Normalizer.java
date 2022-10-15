package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Normalizer{
    List<Number> values;
    
    protected Normalizer(List<? extends Number> values){
        this.values = new ArrayList<>(values);
        updateAttributes();
    }

    public abstract double normalize(Number value);

    public void add(Number value) { this.values.add(value);}
    public void addAll(Collection<Number> values){values.forEach(v -> add(v));}

    protected abstract void updateAttributes();
}
