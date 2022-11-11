package fr.univlille.iutinfo.s3_02.belamcanda.beans;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.titanic.Embarked;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.titanic.Gender;
import fr.univlille.iutinfo.s3_02.belamcanda.point.TitanicPoint;

public class TitanicBean extends Bean<TitanicPoint> {
    @CsvBindByName(column = "PassengerId")
    protected Integer passengerId;
    @CsvBindByName(column = "Survived")
    protected Boolean survived;
    @CsvBindByName(column = "Pclass")
    protected int pClass;
    @CsvBindByName(column = "Name")
    protected String name;
    @CsvBindByName(column = "Sex")
    protected Gender sex;
    @CsvBindByName(column = "Age")
    protected Double age;
    @CsvBindByName(column = "SibSp")
    protected int sibSp;
    @CsvBindByName(column = "Parch")
    protected int parch;
    @CsvBindByName(column = "Ticket")
    protected String ticket;
    @CsvBindByName(column = "Fare")
    protected Double fare;
    @CsvBindByName(column = "Cabin")
    protected String cabin;
    @CsvBindByName(column = "Embarked")
    protected Embarked embarked;

    public Integer getPassengerId() {
        return passengerId;
    }

    public Boolean getSurvived() {
        return survived;
    }

    public int getpClass() {
        return pClass;
    }

    public String getName() {
        return name;
    }

    public Gender getSex() {
        return sex;
    }

    public Double getAge() {
        return age;
    }

    public int getSibSp() {
        return sibSp;
    }

    public int getParch() {
        return parch;
    }

    public String getTicket() {
        return ticket;
    }

    public Double getFare() {
        return fare;
    }

    public String getCabin() {
        return cabin;
    }

    public Embarked getEmbarked() {
        return embarked;
    }

    @Override
    public String toString() {
        return "TitanicBean{" +
                "passengerId=" + passengerId +
                ", survived=" + survived +
                ", pClass=" + pClass +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", sibSp=" + sibSp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked=" + embarked +
                '}';
    }

    @Override
    public TitanicPoint toPoint() {
        return new TitanicPoint(this);
    }
}