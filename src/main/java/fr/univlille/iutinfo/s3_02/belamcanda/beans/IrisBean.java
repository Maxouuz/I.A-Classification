package fr.univlille.iutinfo.s3_02.belamcanda.beans;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.iris.IrisVariety;
import fr.univlille.iutinfo.s3_02.belamcanda.point.IrisPoint;

public class IrisBean extends Bean<IrisPoint>{
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
    public String toString() {
        return "IrisBean{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", variety=" + variety +
                '}';
    }

    @Override
    public IrisPoint toPoint() {
        return new IrisPoint(this);
    }
}
