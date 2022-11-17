package fr.univlille.iutinfo.s3_02.belamcanda.model;

import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.Amplitude;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;

import java.nio.channels.Pipe;
import java.util.Comparator;

public abstract class Column {
	protected MVCModel dataset;
	private final String name;
	private double weight;

	private ColumnComparator comparator;

	public Double compare(Point p1, Point p2){
		return comparator.compare(p1.getNormalizedValue(this), p2.getNormalizedValue(this));
	}

	public Column(String name, double weight) {
		this.name = name;
		this.weight = weight;
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
}