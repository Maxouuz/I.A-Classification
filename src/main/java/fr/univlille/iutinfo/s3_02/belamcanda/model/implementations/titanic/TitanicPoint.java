package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

public class TitanicPoint extends Point {
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

}
