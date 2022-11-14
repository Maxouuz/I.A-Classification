package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;

public class Column implements Observer {
	private MVCModel dataset;
	private final String name;
	private double weight;
	private final IValueNormalizer normalizer;
	protected final Amplitude amplitude;

	public Column(String name, double weight, IValueNormalizer normalizer) {
		this.name = name;
		this.weight = weight;
		this.normalizer = normalizer;
		this.amplitude = new Amplitude();
	}

	public Column(String name, IValueNormalizer normalizer) {
		this(name, 1.0, normalizer);
	}

	public double getNormalizedValue(Point point) {
		Object denormalizedValue = point.getValue(this);
		return normalizer.normalize(denormalizedValue, amplitude);
	}

	public String getName() {
		return name;
	}

	public void setDataset(MVCModel dataset) {
		this.dataset = dataset;
		if (normalizer.needAmplitude()) {
			autoUpdateAmplitude();
		}
	}

	private void autoUpdateAmplitude() {
		dataset.attach(this);
	}


	public IDataset getDataset() {
		return dataset;
	}

	public boolean isNormalizable() {
		return normalizer != null;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
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
}