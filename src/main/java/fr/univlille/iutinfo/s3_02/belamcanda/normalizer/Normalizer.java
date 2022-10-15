package fr.univlille.iutinfo.s3_02.belamcanda.normalizer;

import java.util.List;

public abstract class Normalizer {
    public abstract List<Double> normalize(List<? extends Number> values);
}