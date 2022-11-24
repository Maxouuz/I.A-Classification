package fr.univlille.iutinfo.s3_02.belamcanda.model;


import java.util.*;

/**
 * Decrit un modele de donnee dans le MVC.
 * Un modele de donnee est un {@link IDataset}, il peut en plus lire ses donnees
 * d'un fichier (CSV) ou d'une chaine de caracteres, il a une colonne et une
 * ligne par defaut pour afficher un nuage de point et il peut avoir des
 * categories
 */
public abstract class MVCModel extends Subject implements IDataset {
	protected final Set<Point> trainingData;
	protected final Set<Point> toClassifyData;
	protected final Column[] columns;
	protected final Categories categories;

	protected MVCModel() {
		this.trainingData = new HashSet<>();
		this.toClassifyData = new HashSet<>();
		this.columns = getColumns();
		setDatasetOfColumns();
		this.categories = new Categories();
	}

	public Set<Point> getTrainingData(){return Set.copyOf(trainingData);}


	private void setDatasetOfColumns() {
		for (Column column: columns) {
			column.setDataset(this);
		}
	}

	public abstract Column[] getColumns();
	public List<Column> getColumnList(){return Arrays.asList(getColumns());}
	/**
	 * Retourne la colonne à utiliser par defaut pour l'axe des X lors de
	 * l'affichage du nuage de points.
	 */
	public abstract NormalizableColumn defaultXCol();

	/**
	 * Retourne la colonne à utiliser par defaut pour l'axe des Y lors de
	 * l'affichage du nuage de points.
	 */
	public abstract Column defaultYCol();

	/**
	 * Retourne toutes les categories du modele.
	 */
	public Collection<Category> allCategories() {
		return categories.getCategories();
	}

	/**
	 * Nombre de colonnes dans le modele (egale au nombre de colonnes du DataSet
	 * associe a ce modele)
	 */
	public int nbColumns() {
		return columns.length;
	}

	/**
	 * Retourne la collection de toutes les colonnes du DataSet dont les valeurs
	 * peuvent etre normalisees. Seules les colonnes normalisables peuvent servir
	 * d'axes dans le nuage de points. La normalisation doit retourner une valeur
	 * dans l’intervalle [0;1]
	 */
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
		this.trainingData.clear();
		categories.setLines(lines);
		this.trainingData.addAll(lines);
		notifyObservers();
	}

	@Override
	public void addLine(Point element) {
		this.trainingData.add(element);
		this.trainingData.add(element);
		categories.addLine(element);
		notifyObservers(element);
	}

	@Override
	public void addAllLine(Collection<? extends Point> element) {
		this.trainingData.addAll(element);
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
}
