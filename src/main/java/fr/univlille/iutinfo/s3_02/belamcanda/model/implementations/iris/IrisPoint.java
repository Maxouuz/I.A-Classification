package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;

import java.util.Objects;

public class IrisPoint extends Point {
    @CsvBindByName(column = "sepal.length")
    protected Double sepalLength;
    @CsvBindByName(column = "sepal.width")
    protected Double sepalWidth;
    @CsvBindByName(column = "petal.length")
    protected Double petalLength;
    @CsvBindByName(column = "petal.width")
    protected Double petalWidth;
    @CsvBindByName(column = "variety")
    protected IrisVariety variety;

    @Override
    public Object category() {
        return variety;
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

        if (!Objects.equals(sepalLength, irisPoint.sepalLength))
            return false;
        if (!Objects.equals(sepalWidth, irisPoint.sepalWidth)) return false;
        if (!Objects.equals(petalLength, irisPoint.petalLength))
            return false;
        if (!Objects.equals(petalWidth, irisPoint.petalWidth)) return false;
        return variety == irisPoint.variety;
    }

    @Override
    public int hashCode() {
        int result = sepalLength != null ? sepalLength.hashCode() : 0;
        result = 31 * result + (sepalWidth != null ? sepalWidth.hashCode() : 0);
        result = 31 * result + (petalLength != null ? petalLength.hashCode() : 0);
        result = 31 * result + (petalWidth != null ? petalWidth.hashCode() : 0);
        result = 31 * result + (variety != null ? variety.hashCode() : 0);
        return result;
    }
}
