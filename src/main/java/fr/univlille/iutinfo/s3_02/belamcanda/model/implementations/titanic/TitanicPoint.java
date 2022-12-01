package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Embarked;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Gender;

import java.util.Objects;

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
    protected Embarked embarked = Embarked.NULL;

    @Override
    public Object category() {
        return embarked;
    }

    @Override
    public String toString() {
        return name;
    }

    public TitanicPoint(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitanicPoint that = (TitanicPoint) o;

        if (pClass != that.pClass) return false;
        if (sibSp != that.sibSp) return false;
        if (parch != that.parch) return false;
        if (!Objects.equals(passengerId, that.passengerId)) return false;
        if (!Objects.equals(survived, that.survived)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (sex != that.sex) return false;
        if (!Objects.equals(age, that.age)) return false;
        if (!Objects.equals(ticket, that.ticket)) return false;
        if (!Objects.equals(fare, that.fare)) return false;
        if (!Objects.equals(cabin, that.cabin)) return false;
        return embarked == that.embarked;
    }

    @Override
    public int hashCode() {
        int result = passengerId != null ? passengerId.hashCode() : 0;
        result = 31 * result + (survived != null ? survived.hashCode() : 0);
        result = 31 * result + pClass;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + sibSp;
        result = 31 * result + parch;
        result = 31 * result + (ticket != null ? ticket.hashCode() : 0);
        result = 31 * result + (fare != null ? fare.hashCode() : 0);
        result = 31 * result + (cabin != null ? cabin.hashCode() : 0);
        result = 31 * result + (embarked != null ? embarked.hashCode() : 0);
        return result;
    }
}
