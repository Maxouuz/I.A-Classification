package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;

public abstract class Column implements Observer {
	protected MVCModel dataset;
	private final String name;
	private double weight;
	protected final Amplitude amplitude;

	public Column(String name, double weight) {
		this.name = name;
		this.weight = weight;
		this.amplitude = new Amplitude();
	}

	public Column(String name) {
		this(name, 1.0);
	}

	public abstract double getNormalizedValue(Point point);

	public String getName() {
		return name;
	}

	public void setDataset(MVCModel dataset) {
		this.dataset = dataset;
	}


	public IDataset getDataset() {
		return dataset;
	}

	public abstract boolean isNormalizable();


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

	public Double min(){return amplitude.getMin();}
	public Double max(){return amplitude.getMax();}
}