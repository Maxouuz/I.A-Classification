package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import java.util.List;

public class StandardScoreNormalizer extends Normalizer {
    private double mu;
    private double sigma;

    public double getMean() {
        return mu;
    }

    public double getStandardDeviation() {
        return sigma;
    }

    protected StandardScoreNormalizer(List<? extends Number> values) {
        super(values);
    }

    @Override
    public double normalize(Number value) {
        return (value.doubleValue() - mu) / sigma;
    }

    @Override
    protected void updateAttributes() {
        updateMean();
        updateStD();        
    }

    private void updateMean(){
        double sum = 0;
        for (Number v : values) {
            sum += v.doubleValue();
        }
        mu = sum / values.size();
    }

    private void updateStD(){
        double squaredDiffsum = 0;
        for (Number v : values) {
            squaredDiffsum += ((v.doubleValue() - mu) * (v.doubleValue() - mu));
        }
        sigma = Math.sqrt(squaredDiffsum / values.size());
    }
    
}
