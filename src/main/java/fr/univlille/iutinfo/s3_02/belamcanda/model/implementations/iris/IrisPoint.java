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
        return String.format("Iris (l, h)\n\tSepal (%.2f, %.2f)\n\tPetal (%.2f, %.2f)", sepalLength, sepalWidth, petalLength, petalWidth);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IrisPoint irisPoint = (IrisPoint) o;

        if (Double.compare(irisPoint.sepalLength, sepalLength) != 0) return false;
        if (Double.compare(irisPoint.sepalWidth, sepalWidth) != 0) return false;
        if (Double.compare(irisPoint.petalLength, petalLength) != 0) return false;
        if (Double.compare(irisPoint.petalWidth, petalWidth) != 0) return false;
        return variety == irisPoint.variety;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(sepalLength);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(sepalWidth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(petalLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(petalWidth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (variety != null ? variety.hashCode() : 0);
        return result;
    }
}
