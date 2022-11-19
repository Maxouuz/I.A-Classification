package fr.univlille.iutinfo.s3_02.belamcanda.model;

public class NullPoint extends Point{
    @Override
    public Object category() {
        return null;
    }

    @Override
    public Object getValue(Column col){
        return null;
    }
}
