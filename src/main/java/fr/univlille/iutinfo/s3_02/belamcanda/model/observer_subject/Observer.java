package fr.univlille.iutinfo.s3_02.belamcanda.model.observer_subject;

public interface Observer {

    void update(Subject s);
    void update(Subject s, Object data);

}
