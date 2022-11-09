package fr.univlille.iutinfo.s3_02.belamcanda.colonnes_enum;

import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.normalizer.MinMaxNormalizer;

public enum PokemonColumns implements IColumnDefinition{
    NAME(new Column("name", new NullNormalizer())),
    ATTACK(new Column("attack", new MinMaxNormalizer())),
    BASE_EGG_STEPS(new Column("baseEggSteps", new MinMaxNormalizer())),
    CAPTURE_RATE(new Column("captureRate", new MinMaxNormalizer())),
    DEFENSE(new Column("defense", new MinMaxNormalizer())),
    EXPERIENCE_GROWTH(new Column("experienceGrowth", new MinMaxNormalizer())),
    HP(new Column("hp", new MinMaxNormalizer())),
    SP_ATTACK(new Column("sp_attack", new MinMaxNormalizer())),
    SP_DEFENSE(new Column("sp_defense", new MinMaxNormalizer())),
    TYPE(new Column("type", new MinMaxNormalizer())),
    TYPE_2(new Column("type2", new MinMaxNormalizer())),
    SPEED(new Column("speed", new MinMaxNormalizer())),
    IS_LEGENDARY(new Column("isLegendary", new MinMaxNormalizer()));

    protected Column column;

    private PokemonColumns(Column column){this.column = column;}

    @Override
    public Column getColumn() {      return this.column;    }
}
