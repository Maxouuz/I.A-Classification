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
	protected final Set<Point> datas;
	protected final Column[] columns;
	protected final Categories categories;

	protected MVCModel() {
		this.datas = new HashSet<>();
		this.columns = getColumns();
		setDatasetOfColumns();
		this.categories = new Categories();
	}

	private void setDatasetOfColumns() {
		for (Column column: columns) {
			column.setDataset(this);
		}
	}

	protected abstract Column[] getColumns();

	/**
	 * Retourne la colonne à utiliser par defaut pour l'axe des X lors de
	 * l'affichage du nuage de points.
	 */
	public abstract Column defaultXCol();

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

	@Override
	public int getNbLines() {
		return datas.size();
	}

	@Override
	public void setLines(List<? extends Point> lines) {
		this.datas.clear();
		categories.setLines(lines);
		this.datas.addAll(lines);
		notifyObservers();
	}

	@Override
	public void addLine(Point element) {
		this.datas.add(element);
		categories.addLine(element);
		notifyObservers(element);
	}

	@Override
	public void addAllLine(Collection<? extends Point> element) {
		this.datas.addAll(element);
		categories.addAllLine(element);
		notifyObservers();
	}

	@Override
	public Iterator<Point> iterator() {
		return datas.iterator();
	}

}