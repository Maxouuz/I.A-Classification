package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;

public class PokemonPoint extends Point {
	@CsvBindByName(column = "name")
	public String name;
	@CsvBindByName(column = "attack")
	public int attack;
	@CsvBindByName(column = "base_egg_steps")
	public int baseEggSteps;
	@CsvBindByName(column = "capture_rate")
	public double captureRate;
	@CsvBindByName(column = "defense")
	public int defense;
	@CsvBindByName(column = "experience_growth")
	public int experienceGrowth;
	@CsvBindByName(column = "hp")
	public int hp;
	@CsvBindByName(column = "sp_attack")
	public int spAttack;
	@CsvBindByName(column = "sp_defense")
	public int spDefense;
	@CsvBindByName(column = "type1")
	public PokemonType pokemonType;
	@CsvBindByName(column = "type2")
	public PokemonType pokemonType2 = PokemonType.NONE;
	@CsvBindByName(column = "speed")
	public double speed;
	@CsvBindByName(column = "is_legendary")
	public Legendary isLegendary;

	/*@Override
	public Object category(){
		return isLegendary.getClass().field;
	}*/

	@Override
	public String toLabel() {
		return String.format("%s :\n\tatk : %d\n\tdef : %d\n\thp  : %d",name.toUpperCase(), attack, defense, hp);
	}

	@Override
	public String toString() {
		return name;
	}
}
