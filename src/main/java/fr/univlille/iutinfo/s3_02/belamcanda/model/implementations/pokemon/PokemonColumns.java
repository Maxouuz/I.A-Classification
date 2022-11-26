package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.ColumnFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.NonNormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.NormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.OrdinalNormalizer;

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
    TYPE(new NormalizableColumn("pokemonType", new OrdinalNormalizer<PokemonType>())),
    TYPE_2(new NormalizableColumn("pokemonType2", new OrdinalNormalizer<PokemonType>())),
    SPEED(ColumnFactory.numberColumn("speed")),
    IS_LEGENDARY(new NormalizableColumn("isLegendary", new OrdinalNormalizer<Legendary>()));

    private final Column column;

    PokemonColumns(Column column) {
        this.column = column;
    }

    @Override
    public Column getColumn() {
        return this.column;
    }
}
