package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;

public class NormalizableColumn extends Column implements Observer {
    private final IValueNormalizer normalizer;
    private final Amplitude amplitude;

    public NormalizableColumn(String name, double weight, IValueNormalizer normalizer) {
        super(name, weight);
        this.normalizer = normalizer;
        this.amplitude = new Amplitude();
    }

    public NormalizableColumn(String name, IValueNormalizer normalizer) {
        this(name, 1.0, normalizer);
    }

    @Override
    public double getNormalizedValue(Point point) {
        Object denormalizedValue = point.getValue(this);
        return normalizer.normalize(denormalizedValue, amplitude);
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }

    @Override
    public void setDataset(MVCModel dataset) {
        super.setDataset(dataset);
        if (normalizer.needAmplitude()) {
            autoUpdateAmplitude();
        }
    }

    private void autoUpdateAmplitude() {
        dataset.attach(this);
    }

    @Override
    public void update(Subject s) {
        for (Point point: dataset) {
            amplitude.update((Number) point.getValue(this));
        }
    }

    @Override
    public void update(Subject s, Object data) {
        Point point = (Point) data;
        amplitude.update((Number) point.getValue(this));
    }

    public Double min(){return amplitude.getMin();}
    public Double max(){return amplitude.getMax();}
}
