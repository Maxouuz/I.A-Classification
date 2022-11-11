package fr.univlille.iutinfo.s3_02.belamcanda.beans;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.pokemon.PokemonType;
import fr.univlille.iutinfo.s3_02.belamcanda.point.PokemonPoint;

public class PokemonBean extends Bean<PokemonPoint> {
	@CsvBindByName(column = "name")
	public String name;
	@CsvBindByName(column = "attack")
	protected int attack;
	@CsvBindByName(column = "base_egg_steps")
	protected int baseEggSteps;
	@CsvBindByName(column = "capture_rate")
	protected double captureRate;
	@CsvBindByName(column = "defense")
	protected int defense;
	@CsvBindByName(column = "experience_growth")
	protected int experienceGrowth;
	@CsvBindByName(column = "hp")
	protected int hp;
	@CsvBindByName(column = "sp_attack")
	protected int spAttack;
	@CsvBindByName(column = "sp_defense")
	protected int spDefense;
	@CsvBindByName(column = "type")
	protected PokemonType pokemonType;
	@CsvBindByName(column = "type2")
	protected PokemonType pokemonType2;
	@CsvBindByName(column = "speed")
	protected double speed;
	@CsvBindByName(column = "is_legendary")
	protected boolean isLegendary;


	@Override
	public String toString() {
		return "Pokemon [nom=" + name + ", attack=" + attack + ", baseEggSteps=" + baseEggSteps + ", captureRate="
				+ captureRate + ", defense=" + defense + ", experienceGrowth=" + experienceGrowth + ", hp=" + hp
				+ ", spAttack=" + spAttack + ", spDefense=" + spDefense + ", type=" + pokemonType + ", type2=" + pokemonType2
				+ ", speed=" + speed + ", isLegendary=" + isLegendary + "]";
	}

	@Override
	public PokemonPoint toPoint() {
		return new PokemonPoint(this);
	}
}
