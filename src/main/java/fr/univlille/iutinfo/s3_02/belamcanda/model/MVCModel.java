package fr.univlille.iutinfo.s3_02.belamcanda.model;


import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.NormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.observer_subject.Subject;

import java.util.*;

public abstract class MVCModel extends Subject implements IDataset {
	protected final Class<? extends Point> clazz;
	protected final Set<Point> trainingData;
	protected Set<Point> testData;
	protected final Set<Point> toClassifyData;
	protected final Column[] columns;
	protected final Categories categories;

	protected MVCModel(Class<? extends Point> clazz) {
		this.clazz = clazz;
		this.trainingData = new HashSet<>();
		this.toClassifyData = new HashSet<>();
		this.columns = getColumns();
		setDatasetOfColumns();
		this.categories = new Categories();
	}

	public void setTestData(Set<Point> points){this.testData = points;}
	public Class<? extends Point> pointClass(){return clazz;}

	public Set<Point> getTrainingData(){return Set.copyOf(trainingData);}

	public void setDatasetOfColumns() {
		for (Column column: columns) {
			column.setDataset(this);
		}
	}

	public abstract Column[] getColumns();

	public abstract NormalizableColumn defaultXCol();

	public abstract Column defaultYCol();

	public Collection<Category> allCategories() {
		return categories.getCategories();
	}

	public int nbColumns() {
		return columns.length;
	}

	public List<Column> getNormalizableColumns() {
		List<Column> normalizableColumns = new ArrayList<>();
		for (Column column: columns) {
			if (column.isNormalizable()) {
				normalizableColumns.add(column);
			}
		}
		return normalizableColumns;
	}

	public List<Column> getUsedColumns() {
		List<Column> normalizableColumns = new ArrayList<>();
		for (Column column: columns) {
			if (column.isUsed()) {
				normalizableColumns.add(column);
			}
		}
		return normalizableColumns;
	}

	@Override
	public int getNbLines() {
		return trainingData.size();
	}

	@Override
	public void setLines(List<? extends Point> lines) {
		setDatasetOfColumns();
		this.trainingData.clear();
		this.trainingData.addAll(lines);
		categories.setLines(lines);
		notifyObservers();
	}

	@Override
	public void addLine(Point element) {
		this.trainingData.add(element);
		categories.addLine(element);
		notifyObservers(element);
	}

	@Override
	public void addAllLine(Collection<? extends Point> element) {
		this.trainingData.addAll(element);
		categories.addAllLine(element);
		notifyObservers();
	}

	public Set<Point> getDataToClassify() {
		return toClassifyData;
	}

	public void addDataToClassify(Collection<? extends Point> toClassifyData) {
		this.toClassifyData.addAll(toClassifyData);
	}

	@Override
	public Iterator<Point> iterator() {
		return trainingData.iterator();
	}

	public Column getColumn(IColumnDefinition definition) {
		for (Column column: columns) {
			if (column.equals(definition.getColumn())) {
				return column;
			}
		}
		throw new IllegalArgumentException();
	}
}
