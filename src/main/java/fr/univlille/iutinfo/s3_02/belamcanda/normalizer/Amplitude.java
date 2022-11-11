package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

public class Amplitude {
    protected Double min;
    protected Double max;
    protected Double average;
    protected double variance;
    protected int size;

    public Amplitude() {
        size = 0;
        variance = 0;
    }

    public void update(Number... numbers) {
        double newValue;
        for (Number number : numbers) {
            newValue = number.doubleValue();
            updateMinMax(newValue);
            updateVariance(newValue);
            updateAverage(newValue);
            size++;
        }
    }

    private void updateVariance(double newValue) {
        if (isEmpty()) return;
        variance = size / (size + 1.0) * (variance + Math.pow(average - newValue, 2) / (size + 1.0));
    }

    private void updateAverage(double newValue) {
        if (average == null) {
            average = newValue;
        } else {
            average = (average * size + newValue) / (size + 1);
        }
    }

    private void updateMinMax(double newValue) {
        if (isEmpty() || getMin() > newValue) min = newValue;
        if (isEmpty() || getMax() < newValue) max = newValue;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    public Double getAverage() {
        return average;
    }

    public Double getVariance() {
        return variance;
    }

    public Double getStandardDeviation() {
        return Math.sqrt(variance);
    }
}