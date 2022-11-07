package fr.univlille.iutinfo.s3_02.belamcanda;

import fr.univlille.iutinfo.s3_02.belamcanda.normalizer.Normalizer;

/**
 * Decrit une <i>colonne</i> d'un DataSet.
 *
 * Une colonne a un nom, son DataSet parent et un normaliseur optionnel.
 *
 * Un normaliseur traduit toutes les valeurs possibles de la colonne (dans son
 * DataSet) en une valeur entre 0 et 1. Seule les colonnes <i>normalisables</i>
 * (qui ont un normaliseur) peuvent etre utilisees comme axe dans le nuage de
 * points.
 */
public class Column {
	private IDataset dataset;
	private String name;
	private double weight;
	private IValueNormalizer normalizer;

	public Column(IDataset dataset, String name, double weight, IValueNormalizer normalizer) {
		this.name = name;
		this.weight = weight;
		this.normalizer = normalizer;
	}

	/**
	 * Recupere la valeur de cette colonne dans la donnee en parametre, puis
	 * normalise cette valeur )entre 0 et 1) et la retourne normalisee. Si la
	 * colonne n'est pas normalisable, le comportement n'est pas definit.
	 */
	public double getNormalizedValue(IPoint point) {
		Object denormalizedValue = point.getValue(this);
		return normalizer.normalize(denormalizedValue);
	}

	/**
	 * "Denormalise" une valeur entre 0 et 1 en une "vraie" valeur pour cette
	 * colonne. Si la colonne n'est pas normalisable, le comportement n'est pas
	 * definit.
	 */
	public Object getDenormalizedValue(double value) {
		return normalizer.denormalize(value);
	}

	/**
	 * Retourne le nom de la colonne.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retourne le DataSet auquel cette colonne appartient.
	 */
	public IDataset getDataset() {
		return dataset;
	}

	/**
	 * Indique si cette colonne est normalisable (a un <i>normaliseur</i>).
	 */
	public boolean isNormalizable() {
		return normalizer != null;
	}

	/**
	 * Permet de donner un poids a cette colonne
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * Retourne le poids de la colonne
	 */
	public double getWeight() {
		return weight;
	}
}