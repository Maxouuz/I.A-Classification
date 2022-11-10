package fr.univlille.iutinfo.s3_02.belamcanda.beans;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.point.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.PokemonType;

public class PokemonBean extends Point {
	@CsvBindByName(column = "name")
	private String nom;
	@CsvBindByName(column = "attack")
	private int attack;
	@CsvBindByName(column = "base_egg_steps")
	private int baseEggSteps;
	@CsvBindByName(column = "capture_rate")
	private double captureRate;
	@CsvBindByName(column = "defense")
	private int defense;
	@CsvBindByName(column = "experience_growth")
	private int experienceGrowth;
	@CsvBindByName(column = "hp")
	private int hp;
	@CsvBindByName(column = "sp_attack")
	private int spAttack;
	@CsvBindByName(column = "sp_defense")
	private int spDefense;
	@CsvBindByName(column = "type")
	private PokemonType pokemonType;
	@CsvBindByName(column = "type2")
	private PokemonType pokemonType2;
	@CsvBindByName(column = "speed")
	private double speed;
	@CsvBindByName(column = "is_legendary")
	private boolean isLegendary;

	@Override
	public String toString() {
		return "Pokemon [nom=" + nom + ", attack=" + attack + ", baseEggSteps=" + baseEggSteps + ", captureRate="
				+ captureRate + ", defense=" + defense + ", experienceGrowth=" + experienceGrowth + ", hp=" + hp
				+ ", spAttack=" + spAttack + ", spDefense=" + spDefense + ", type=" + pokemonType + ", type2=" + pokemonType2
				+ ", speed=" + speed + ", isLegendary=" + isLegendary + "]";
	}

	@Override
	public Object getValue(Column col) {
		return null;
	}
}
