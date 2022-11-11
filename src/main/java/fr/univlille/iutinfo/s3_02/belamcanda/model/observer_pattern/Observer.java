package fr.univlille.iutinfo.s3_02.belamcanda.model.observer_pattern;

public interface Observer {

    void update(Subject s);
    void update(Subject s, Object data);

}
