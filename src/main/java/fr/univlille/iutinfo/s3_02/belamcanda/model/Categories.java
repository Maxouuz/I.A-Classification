package fr.univlille.iutinfo.s3_02.belamcanda.model;

import java.util.*;

public class Categories {
    protected final Map<Object, Category> categories;

    public Categories() {
        this.categories = new HashMap<>();
    }

    public void setLines(List<? extends Point> lines) {
        categories.clear();
        addAllLine(lines);
    }

    public void addLine(Point element) {
        Object category = element.category();
        if (category == null) return;
        categories.putIfAbsent(category, new Category(category.toString()));
        categories.get(category).addLine(element);
    }

    public void addAllLine(Collection<? extends Point> elements) {
        for (Point element: elements) {
            addLine(element);
        }
    }

    public Collection<Category> getCategories() {
        return categories.values();
    }
}
