package fr.univlille.iutinfo.s3_02.belamcanda;


import fr.univlille.iutinfo.s3_02.belamcanda.colonnes_enum.PokemonColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;

import java.util.*;

/**
 * Decrit un modele de donnee dans le MVC.
 *
 * Un modele de donnee est un {@link IDataset}, il peut en plus lire ses donnees
 * d'un fichier (CSV) ou d'une chaine de caracteres, il a une colonne et une
 * ligne par defaut pour afficher un nuage de point et il peut avoir des
 * categories
 */
public abstract class MVCModel implements IDataset {
	protected Set<Point> datas;
	protected Column[] columns;
	protected Set<ICategory> categories;

	protected MVCModel() {
		this.datas = new HashSet<>();
		this.columns = getColumns();
		this.categories = new HashSet<>();
	}

	protected abstract Column[] getColumns();

	/**
	 * Retourne la colonne a utiliser par defaut pour l'axe des X lors de
	 * l'affichage du nuage de points.
	 */
	public abstract Column defaultXCol();

	/**
	 * Retourne la colonne a utiliser par defaut pour l'axe des Y lors de
	 * l'affichage du nuage de points.
	 */
	public abstract Column defaultYCol();

	/**
	 * Ajoute une Categorie (ou classe) de donnees au model.
	 */
	public void addCategory(ICategory classe) {
		categories.add(classe);
	}

	/**
	 * Retourne toutes les categories du modele.
	 */
	public Collection<ICategory> allCategories() {
		return new ArrayList<>(categories);
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
	public void setLines(List<Point> lines) {
		this.datas.clear();
		this.datas.addAll(lines);
	}

	@Override
	public void addLine(Point element) {
		this.datas.add(element);
	}

	@Override
	public void addAllLine(List<Point> element) {
		this.datas.addAll(element);
	}

	@Override
	public Iterator<Point> iterator() {
		return datas.iterator();
	}
}