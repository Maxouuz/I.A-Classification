package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.Legendary;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.qualitative_variables.PokemonType;

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


	public Object category(){
		return isLegendary;
	}

	@Override
	public String toString() {
		return name;
	}

	public PokemonPoint(){}

	/**public PokemonPoint(String name, int attack, int baseEggSteps, double captureRate, int defense, int experienceGrowth, int hp, int spAttack, int spDefense, PokemonType pokemonType, PokemonType pokemonType2, double speed, Legendary isLegendary){
	this.name = name;
	this.attack = attack;
	this.baseEggSteps = baseEggSteps;
	this.captureRate = captureRate;
	this.defense = defense;
	this.experienceGrowth = experienceGrowth;
	this.hp = hp;
	this.spAttack = spAttack;
	this.spDefense = spDefense;
	this.pokemonType = pokemonType;
	this.pokemonType2 = pokemonType2;
	this.speed = speed;
	this.isLegendary = isLegendary;
	}**/
}
