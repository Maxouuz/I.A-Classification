package fr.univlille.iutinfo.s3_02.belamcanda.model.distance;

import fr.univlille.iutinfo.s3_02.belamcanda.model.Column;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.iris.IrisColumns;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;
import java.io.IOException;

public class TestRandomDistance {
    final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator ;
    private MVCModel model;
    private RandomDistance distance;
    private Column weightedColumn;

    @BeforeEach
    public void initialization() throws IOException {
        String dataPath = DATA_PATH + "iris.csv";
        weightedColumn = IrisColumns.SEPAL_WIDTH.getColumn();
        weightedColumn.setWeight(1.0);
        model = new CSVLoader().createModelFromFile(CSVModel.IRIS, dataPath);
        distance = new RandomDistance();
    }
    /** TODO Pour maxhoue */


}
