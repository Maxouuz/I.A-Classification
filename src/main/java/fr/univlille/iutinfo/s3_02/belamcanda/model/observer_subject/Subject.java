package fr.univlille.iutinfo.s3_02.belamcanda.model.observer_subject;

import java.util.HashSet;
import java.util.Set;

public abstract class Subject {
    protected Set<Observer> observers = new HashSet<>();

    public Set<Observer> observers(){return Set.copyOf(observers);}

    public void attach(Observer o){
        observers.add(o);
    }
    public void detach(Observer o){
        observers.remove(o);
    }
    public void notifyObservers(){
        observers.forEach(o -> o.update(this));
    }
}
