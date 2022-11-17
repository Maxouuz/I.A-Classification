package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.*;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

public enum PokemonColumns implements IColumnDefinition {
    NAME(new NonNormalizableColumn("name")),
    ATTACK(new NumberColumn("attack")),
    BASE_EGG_STEPS(new NumberColumn("baseEggSteps")),
    CAPTURE_RATE(new NumberColumn("captureRate")),
    DEFENSE(new NumberColumn("defense")),
    EXPERIENCE_GROWTH(new NumberColumn("experienceGrowth")),
    HP(new NumberColumn("hp")),
    SP_ATTACK(new NumberColumn("spAttack")),
    SP_DEFENSE(new NumberColumn("spDefense")),
    TYPE(new NormalizableColumn("pokemonType", new PokemonTypeNormalizer())),
    TYPE_2(new NormalizableColumn("pokemonType2", new PokemonTypeNormalizer())),
    SPEED(new NumberColumn("speed")),
    IS_LEGENDARY(new NormalizableColumn("isLegendary", new LegendaryNormalizer()));

    final Column column;

    PokemonColumns(Column column) {
        this.column = column;
    }

    @Override
    public Column getColumn() {
        return this.column;
    }
}
