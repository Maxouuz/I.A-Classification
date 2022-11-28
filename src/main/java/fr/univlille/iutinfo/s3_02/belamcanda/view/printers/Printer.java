package fr.univlille.iutinfo.s3_02.belamcanda.view.printers;

public abstract class Printer<T> { //NOPMD - suppressed AbstractNaming - TODO explain reason for suppression
    public void print(T obj){
        System.out.println(toString(obj));
    }

    public abstract String toString(T obj);


}
