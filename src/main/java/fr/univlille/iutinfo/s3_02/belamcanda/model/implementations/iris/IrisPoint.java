package fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris;

import com.opencsv.bean.CsvBindByName;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.qualitative_variables.IrisVariety;

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

    public IrisPoint(){}

    public IrisPoint(Double sepalLength, Double sepalWidth, Double petalLength, Double petalWidth, IrisVariety variety ){
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.variety = variety;
    }
}
