package fr.univlille.iutinfo.s3_02.belamcanda.view.printers;

public abstract class Printer<T> {
    public void print(T obj){
        System.out.println(toString(obj));
    }

    public abstract String toString(T obj);


}
