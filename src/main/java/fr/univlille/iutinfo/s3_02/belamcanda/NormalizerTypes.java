package fr.univlille.iutinfo.s3_02.belamcanda;

public enum NormalizerTypes {
    NUMBER_NORMALIZER, BOOLEAN_NORMALIZER, POKEMON_TYPE_NORMALIZER;
    }
    /**
    * Retourne la valeur en parametre normalisee (entre 0 et 1).
    */
    public double normalize(Object value);
    /**
    * De-normalise la valeur en parametre (qui est entre 0 et 1)
    * Retourne la « vraie » valeur correspondante pour la colonne
    * associee au normaliseur
    */
    public Object denormalize(double value);
    }
    /**
    * Decrit une categorie. Toute categorie peut etre vue comme un Dataset, elle a
    un nom et un ensemble de point qui lui appartiennent.
    *
    * Cette interface n'ajoute aucune methode a sa super-interface
    * <code>IDataset</code>, elle sert seulement a marquer un type.
    */
