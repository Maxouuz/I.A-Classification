package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;

import java.util.Objects;

public class PokemonPoint extends Point {
	@CsvBindByName(column = "name")
	protected String name;
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
	@CsvBindByName(column = "type1")
	protected PokemonType pokemonType;
	@CsvBindByName(column = "type2")
	protected PokemonType pokemonType2 = PokemonType.NONE;
	@CsvBindByName(column = "speed")
	protected double speed;
	@CsvBindByName(column = "is_legendary")
	protected Legendary isLegendary;

	@Override
	public Object category(){
		return isLegendary;
	}

	@Override
	public String toString() {
		return name;
	}

	public PokemonPoint(){}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		PokemonPoint that = (PokemonPoint) o;

		if (attack != that.attack) return false;
		if (baseEggSteps != that.baseEggSteps) return false;
		if (Double.compare(that.captureRate, captureRate) != 0) return false;
		if (defense != that.defense) return false;
		if (experienceGrowth != that.experienceGrowth) return false;
		if (hp != that.hp) return false;
		if (spAttack != that.spAttack) return false;
		if (spDefense != that.spDefense) return false;
		if (Double.compare(that.speed, speed) != 0) return false;
		if (!Objects.equals(name, that.name)) return false;
		if (pokemonType != that.pokemonType) return false;
		if (pokemonType2 != that.pokemonType2) return false;
		return isLegendary == that.isLegendary;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = name != null ? name.hashCode() : 0;
		result = 31 * result + attack;
		result = 31 * result + baseEggSteps;
		temp = Double.doubleToLongBits(captureRate);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + defense;
		result = 31 * result + experienceGrowth;
		result = 31 * result + hp;
		result = 31 * result + spAttack;
		result = 31 * result + spDefense;
		result = 31 * result + (pokemonType != null ? pokemonType.hashCode() : 0);
		result = 31 * result + (pokemonType2 != null ? pokemonType2.hashCode() : 0);
		temp = Double.doubleToLongBits(speed);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + (isLegendary != null ? isLegendary.hashCode() : 0);
		return result;
	}
}
