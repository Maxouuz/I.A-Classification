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
}
