package fr.univlille.iutinfo.s3_02.belamcanda.model;


import fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.NormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.observer_subject.Subject;

import java.io.IOException;
import java.util.*;

public abstract class MVCModel extends Subject implements IDataset {
	protected final CSVModel csvModel;
	protected final Set<Point> trainingData;
	protected final Set<Point> toClassifyData;
	protected final Set<Point> testData;
	protected final Column[] columns;
	protected final Categories categories;

	protected MVCModel(CSVModel csvModel) {
		this.csvModel = csvModel;

		this.trainingData = new HashSet<>();
		this.toClassifyData = new HashSet<>();
		this.testData = new HashSet<>();

		this.columns = getColumns();
		setDatasetOfColumns();
		this.categories = new Categories();
	}

	public Set<Point> getTrainingData(){return trainingData;}

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
		this.trainingData.clear();
		this.trainingData.addAll(lines);
		categories.setLines(lines);
		notifyObservers();
	}

	public Set<Point> getTestData() {
		return testData;
	}

	public List<Point> setTestData(String path) throws IOException {
		List<Point> newDataToClassify = new CSVLoader().loadFromFile(csvModel, path);
		this.testData.addAll(newDataToClassify);
		return newDataToClassify;
	}

	public Set<Point> getDataToClassify() {
		return toClassifyData;
	}

	public void addPointToClassify(Point newPoint) {
		this.toClassifyData.add(newPoint);
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

	public CSVModel getCsvModel() {
		return csvModel;
	}

	public void classify() {
		Categorizer categorizer = new Categorizer(this, new EuclideanDistance(), 3);
		for (Point toClassify: toClassifyData) {
			Object guess = categorizer.categorize(toClassify);
			toClassify.setCategory(guess);
		}
	}
}
