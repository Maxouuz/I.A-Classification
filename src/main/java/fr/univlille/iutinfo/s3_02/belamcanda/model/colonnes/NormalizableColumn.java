package fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes;

import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.comparator.ColumnComparator;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.observer_subject.Observer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.observer_subject.Subject;

import java.util.Objects;

public class NormalizableColumn extends Column implements Observer {
    private final IValueNormalizer normalizer;
    Amplitude amplitude;

    public NormalizableColumn(String name, double weight, IValueNormalizer normalizer) {
        super(name, weight);
        this.normalizer = normalizer;
        this.amplitude = new Amplitude();
        used = true;
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
    public Double compare(Point p1, Point p2) {
        // TODO: Y'a une loi de demeter (pas très envie de transformer le normalizer en classe abstraite)
        ColumnComparator comparator = normalizer.getComparator();
        return comparator.compare(getNormalizedValue(p1), getNormalizedValue(p2));
    }

    @Override
    public boolean isNormalizable() {
        return true;
    }

    @Override
    public boolean isNumeric() {
        return  normalizer.needAmplitude();
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

    public void resetAmplitude(){this.amplitude = new Amplitude();}

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

    public Amplitude amplitude() {
        return amplitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NormalizableColumn that = (NormalizableColumn) o;
        return Objects.equals(normalizer, that.normalizer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(normalizer);
    }
}
