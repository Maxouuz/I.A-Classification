package fr.univlille.iutinfo.s3_02.belamcanda.distance;

public class EuclidianDistance extends Distance {

    @Override
    protected double distance(Number n1, Number n2) {
        return Math.pow(n1.doubleValue() - n2.doubleValue(), 2);
    }

}
