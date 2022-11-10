package fr.univlille.iutinfo.s3_02.belamcanda.beans;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.iris.IrisVariety;

public class IrisBean {
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

    public Double getSepalLength() {
        return sepalLength;
    }

    public Double getSepalWidth() {
        return sepalWidth;
    }

    public Double getPetalLength() {
        return petalLength;
    }

    public Double getPetalWidth() {
        return petalWidth;
    }

    public IrisVariety getVariety() {
        return variety;
    }

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
}
