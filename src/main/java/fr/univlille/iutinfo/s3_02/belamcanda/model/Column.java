package fr.univlille.iutinfo.s3_02.belamcanda.model;

public abstract class Column {
	protected MVCModel dataset;
	private final String name;
	private double weight;

	public Column(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public Column(String name) {
		this(name, 1.0);
	}

	public abstract double getNormalizedValue(Point point);

	public abstract Double compare(Point p1, Point p2);

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
	public boolean isNumeric(){return false;}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return this.name;
	}
}