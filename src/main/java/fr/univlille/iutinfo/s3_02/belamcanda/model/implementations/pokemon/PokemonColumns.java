package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.BooleanNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NullNormalizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.normalizer.NumberNormalizer;

public enum PokemonColumns implements IColumnDefinition {
    NAME(new Column("name", new NullNormalizer())),
    ATTACK(new Column("attack", new NumberNormalizer())),
    BASE_EGG_STEPS(new Column("baseEggSteps", new NumberNormalizer())),
    CAPTURE_RATE(new Column("captureRate", new NumberNormalizer())),
    DEFENSE(new Column("defense", new NumberNormalizer())),
    EXPERIENCE_GROWTH(new Column("experienceGrowth", new NumberNormalizer())),
    HP(new Column("hp", new NumberNormalizer())),
    SP_ATTACK(new Column("sp_attack", new NumberNormalizer())),
    SP_DEFENSE(new Column("sp_defense", new NumberNormalizer())),
    TYPE(new Column("type", new NumberNormalizer())),
    TYPE_2(new Column("type2", new NumberNormalizer())),
    SPEED(new Column("speed", new NumberNormalizer())),
    IS_LEGENDARY(new Column("isLegendary", new BooleanNormalizer()));

    final Column column;

    PokemonColumns(Column column){this.column = column;}

    @Override
    public Column getColumn() {      return this.column;    }
}
