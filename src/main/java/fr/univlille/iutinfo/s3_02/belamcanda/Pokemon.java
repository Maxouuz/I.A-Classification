package fr.univlille.iutinfo.s3_02.belamcanda;

import com.opencsv.bean.CsvBindByName;

public class Pokemon {
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
	private Type type;
	@CsvBindByName(column = "type2")
	private Type type2;
	@CsvBindByName(column = "speed")
	private double speed;
	@CsvBindByName(column = "is_legendary")
	private boolean isLegendary;

	@Override
	public String toString() {
		return "Pokemon [nom=" + nom + ", attack=" + attack + ", baseEggSteps=" + baseEggSteps + ", captureRate="
				+ captureRate + ", defense=" + defense + ", experienceGrowth=" + experienceGrowth + ", hp=" + hp
				+ ", spAttack=" + spAttack + ", spDefense=" + spDefense + ", type=" + type + ", type2=" + type2
				+ ", speed=" + speed + ", isLegendary=" + isLegendary + "]";
	}
}
