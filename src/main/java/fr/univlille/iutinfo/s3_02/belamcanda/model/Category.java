package fr.univlille.iutinfo.s3_02.belamcanda.model;

import java.util.*;

public class Category implements IDataset {
    private final String title;
    private final Set<Point> datas;

    public Category(String title) {
        this.title = title;
        datas = new HashSet<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getNbLines() {
        return datas.size();
    }

    @Override
    public void setLines(List<? extends Point> lines) {
        datas.clear();
        addAllLine(lines);
    }

    public void addLine(Point element) {
        datas.add(element);
    }

    public void addAllLine(Collection<? extends Point> element) {
        datas.addAll(element);
    }

    @Override
    public Iterator<Point> iterator() {
        return datas.iterator();
    }
}
