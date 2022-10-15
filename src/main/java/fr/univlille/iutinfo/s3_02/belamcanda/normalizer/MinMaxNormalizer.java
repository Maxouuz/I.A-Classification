package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import java.util.List;

public class MinMaxNormalizer extends Normalizer {
    private Number min;
    private Number max;

    public Number getMin() {
        return min;
    }

    public Number getMax() {
        return max;
    }

    protected MinMaxNormalizer(List<? extends Number> values) {
        super(values);
    }

    @Override
    public double normalize(Number value) {
        return (value.doubleValue() - min.doubleValue()) / (max.doubleValue() - min.doubleValue());
    }

    @Override
    protected void updateAttributes() {
        this.values.forEach(v -> setMinMax(v));
    }

    public void add(Number v){
        super.add(v);
        setMinMax(v);
    }

    private void setMinMax(Number v){
        if (min == null || v.doubleValue() < min.doubleValue()) min =v;
        if (max == null || v.doubleValue() > max.doubleValue()) max =v;
    }
    
}
