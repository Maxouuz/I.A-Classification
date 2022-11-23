package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Embarked;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Gender;

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
    protected Double age = 0.0;
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
    public Object category() {
        return embarked;
    }

    @Override
    public String toString() {
        return name;
    }

    public TitanicPoint(){}

    /**public TitanicPoint(Integer passengerId, Boolean survived, int pClass, String name, Gender sex, Double age, int sibSp, int parch, String ticket, Double fare, String cabin, Embarked embarked){
        this.passengerId = passengerId;
        this.survived = survived;
        this.pClass = pClass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibSp = sibSp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }*/
}
