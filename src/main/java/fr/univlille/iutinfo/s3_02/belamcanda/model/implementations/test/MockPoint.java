package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.test;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.titanic.qualitative_variables.Gender;

public class MockPoint extends Point {
    String name;
    double age;
    int shoeSize;
    Gender gender;
    boolean isReligious;

    public MockPoint(String name, double age, int shoeSize, Gender gender, boolean isReligious) {
        this.name = name;
        this.age = age;
        this.shoeSize = shoeSize;
        this.gender = gender;
        this.isReligious = isReligious;
    }

    @Override
    public Object category() {
        return isReligious;
    }

    @Override
    public String toString() {
        return name;
    }
}
