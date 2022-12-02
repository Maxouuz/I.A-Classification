package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Embarked;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Gender;

public class TitanicPoint extends Point {
    @CsvBindByName(column = "PassengerId")
    public int passengerId;
    @CsvBindByName(column = "Survived")
    public boolean survived;
    @CsvBindByName(column = "Pclass")
    public int pClass;
    @CsvBindByName(column = "Name")
    public String name;
    @CsvBindByName(column = "Sex")
    public Gender sex;
    @CsvBindByName(column = "Age")
    public double age;
    @CsvBindByName(column = "SibSp")
    public int sibSp;
    @CsvBindByName(column = "Parch")
    public int parch;
    @CsvBindByName(column = "Ticket")
    public String ticket;
    @CsvBindByName(column = "Fare")
    public double fare;
    @CsvBindByName(column = "Cabin")
    public String cabin;
    @CsvBindByName(column = "Embarked")
    public Embarked embarked = Embarked.NULL;

    @Override
    public Object category() {
        return embarked;
    }

    @Override
    public String toLabel() {
        return String.format("%s :\n\tClass : %d\n\tAge : %.2f\n\tFare : %.2f", name, pClass, age, fare);
    }

    @Override
    public String toString() {
        return name;
    }

    public TitanicPoint(){}
}
