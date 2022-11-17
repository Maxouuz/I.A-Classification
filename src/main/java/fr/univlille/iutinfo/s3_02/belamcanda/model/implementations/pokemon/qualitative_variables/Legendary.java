package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables;

public enum Legendary {
    TRUE("Legendary"), FALSE("Not legendary");

    private final String label;

    Legendary(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }
}
