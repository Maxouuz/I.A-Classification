package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;

public class IrisPoint extends Point {
    @CsvBindByName(column = "sepal.length")
    public double sepalLength;
    @CsvBindByName(column = "sepal.width")
    public double sepalWidth;
    @CsvBindByName(column = "petal.length")
    public double petalLength;
    @CsvBindByName(column = "petal.width")
    public double petalWidth;
    @CsvBindByName(column = "variety")
    public IrisVariety variety;

    @Override
    public Object category() {
        return variety;
    }

    @Override
    public String toLabel() {
        return String.format("Iris :\n\tSepal l=%.2f; h=%.2f\n\tPetal l=%.2f; h=%.2f", sepalLength, sepalWidth, petalLength, petalWidth);
    }

    @Override
    public String toString() {
        return sepalLength + " " + sepalWidth + " " + petalLength + " " + petalLength + " " + variety;
    }

    public IrisPoint(){}

    public IrisPoint(Double sepalLength, Double sepalWidth, Double petalLength, Double petalWidth, IrisVariety variety ){
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.variety = variety;
    }
}
