package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.NormalizableColumn;
import fr.univlille.iutinfo.s3_02.belamcanda.model.colonnes_enum.IColumnDefinition;

public class PokemonModel extends MVCModel {
	public PokemonModel() {
		super(PokemonPoint.class);
	}

	@Override
	public String getTitle() {
		return "Pokémon";
	}

	@Override
	public Column[] getColumns() {
		return IColumnDefinition.getColumns(PokemonColumns.values());
	}

	@Override
	public NormalizableColumn defaultXCol() {
		return (NormalizableColumn)PokemonColumns.BASE_EGG_STEPS.getColumn();
	}

	@Override
	public NormalizableColumn defaultYCol() {
		return (NormalizableColumn)PokemonColumns.CAPTURE_RATE.getColumn();
	}
}
