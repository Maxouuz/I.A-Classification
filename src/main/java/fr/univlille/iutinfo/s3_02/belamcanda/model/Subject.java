package fr.univlille.iutinfo.s3_02.belamcanda.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Subject {
    protected Set<Observer> observers = new HashSet<>();

    public void attach(Observer o){
        observers.add(o);
    }
    public void detach(Observer o){
        observers.remove(o);
    }
    public void notifyObservers(){
        observers.forEach(o -> o.update(this));
    }
    public void notifyObservers(Object data){
        observers.forEach(o -> o.update(this, data));
    }
}
