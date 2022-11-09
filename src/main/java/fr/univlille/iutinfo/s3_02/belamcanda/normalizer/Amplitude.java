package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

public class Amplitude {
    protected Number min;
    protected Number max;

    public void update (Number number){
        if (min == null || min.doubleValue()>number.doubleValue()) min = number;
        if (max == null || max.doubleValue()<number.doubleValue()) max = number;
    }

    public Number getMin() {
        return min;
    }

    public Number getMax() {
        return max;
    }
}
