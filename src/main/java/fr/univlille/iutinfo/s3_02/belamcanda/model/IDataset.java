package fr.univlille.iutinfo.s3_02.belamcanda.model;

import java.util.Collection;
import java.util.List;

public interface IDataset extends Iterable<Point> {
	String getTitle();

	int getNbLines();

	void setLines(List<? extends Point> lines);

	void addLine(Point element);

	void addAllLine(Collection<? extends Point> element);
}
