package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonColumns;

public class PokemonModel extends MVCModel {
	@Override
	public String getTitle() {
		return "Pokémon";
	}

	@Override
	protected Column[] getColumns() {
		return IColumnDefinition.getColumns(PokemonColumns.values());
	}

	@Override
	public Column defaultXCol() {
		return PokemonColumns.BASE_EGG_STEPS.getColumn();
	}

	@Override
	public Column defaultYCol() {
		return PokemonColumns.CAPTURE_RATE.getColumn();
	}
}
