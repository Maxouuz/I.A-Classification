package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.ColumnFactory;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.IValueNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.OrdinalNormalizer;

public enum PokemonColumns implements IColumnDefinition {
    NAME("name"),
    ATTACK("attack", new NumberNormalizer()),
    BASE_EGG_STEPS("baseEggSteps", new NumberNormalizer()),
    CAPTURE_RATE("captureRate", new NumberNormalizer()),
    DEFENSE("defense", new NumberNormalizer()),
    EXPERIENCE_GROWTH("experienceGrowth", new NumberNormalizer()),
    HP("hp", new NumberNormalizer()),
    SP_ATTACK("spAttack", new NumberNormalizer()),
    SP_DEFENSE("spDefense", new NumberNormalizer()),
    TYPE("pokemonType", new OrdinalNormalizer<PokemonType>()),
    TYPE_2("pokemonType2", new OrdinalNormalizer<PokemonType>()),
    SPEED("speed", new NumberNormalizer()),
    IS_LEGENDARY("isLegendary");

    final String name;
    final IValueNormalizer normalizer;

    PokemonColumns(String name, IValueNormalizer normalizer) {
        this.name = name;
        this.normalizer = normalizer;
    }

    PokemonColumns(String name) {
        this.name = name;
        this.normalizer = null;
    }

    @Override
    public Column getColumn() {
        return ColumnFactory.createColumn(name, normalizer);
    }
}
