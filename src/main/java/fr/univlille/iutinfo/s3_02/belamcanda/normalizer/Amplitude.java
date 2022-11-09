package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

public class Amplitude {
    protected Number min;
    protected Number max;

    public void update (Number number){
        if (min == null || getMin()>number.doubleValue()) min = number;
        if (max == null || getMax().doubleValue()<number.doubleValue()) max = number;
    }

    public Double getMin() {
        return min.doubleValue();
    }

    public Double getMax() {
        return max.doubleValue();
    }
}
