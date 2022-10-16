package fr.univlille.iutinfo.s3_02.belamcanda.distance;

public class ManhattanDistance extends Distance{

    @Override
    protected double distance(Number n1, Number n2) {
        return Math.abs(n1.doubleValue() - n2.doubleValue());
    }
    
}
