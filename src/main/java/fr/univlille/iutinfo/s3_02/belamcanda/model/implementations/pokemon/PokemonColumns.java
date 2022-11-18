package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.ColumnFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.model.NonNormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.NormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

public enum PokemonColumns implements IColumnDefinition {
    NAME(new NonNormalizableColumn("name")),
    ATTACK(ColumnFactory.numberColumn("attack")),
    BASE_EGG_STEPS(ColumnFactory.numberColumn("baseEggSteps")),
    CAPTURE_RATE(ColumnFactory.numberColumn("captureRate")),
    DEFENSE(ColumnFactory.numberColumn("defense")),
    EXPERIENCE_GROWTH(ColumnFactory.numberColumn("experienceGrowth")),
    HP(ColumnFactory.numberColumn("hp")),
    SP_ATTACK(ColumnFactory.numberColumn("spAttack")),
    SP_DEFENSE(ColumnFactory.numberColumn("spDefense")),
    TYPE(new NormalizableColumn("pokemonType", new PokemonTypeNormalizer())),
    TYPE_2(new NormalizableColumn("pokemonType2", new PokemonTypeNormalizer())),
    SPEED(ColumnFactory.numberColumn("speed")),
    IS_LEGENDARY(new NormalizableColumn("isLegendary", new LegendaryNormalizer()));

    private final Column column;

    PokemonColumns(Column column) {
        this.column = column;
    }

    @Override
    public Column getColumn() {
        return this.column;
    }
}
