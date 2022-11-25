package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import com.opencsv.bean.CsvToBeanBuilder;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;


import java.util.List;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVLoader {
    public List<Point> loadFromFile(Class<? extends Point> clazz, String path, char separator) throws IOException {
        List<Point> res;
        res = new CsvToBeanBuilder<Point>(Files.newBufferedReader(Paths.get(path)))
                .withSeparator(separator)
                .withType(clazz)
                .build().parse();
        return res;
    }

    public List<Point> loadFromFile(CSVModel csvModel, String path) throws IOException {
        List<Point> res;
        res = new CsvToBeanBuilder<Point>(Files.newBufferedReader(Paths.get(path)))
                .withSeparator(csvModel.getSeparator())
                .withType(csvModel.getClazz())
                .build().parse();
        return res;
    }

    public MVCModel createModelFromFile(CSVModel csvModel, String path) throws IOException {
        MVCModel model = csvModel.getModel();
        model.setLines(loadFromFile(csvModel, path));
        return model;
    }

}
