package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import com.opencsv.bean.CsvToBeanBuilder;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;


import java.util.List;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVLoader {
    public List<Point> loadFromFile(CSVModel csvModel, String path) throws IOException {
        List<Point> res;
        res = new CsvToBeanBuilder<Point>(Files.newBufferedReader(Paths.get(path)))
                .withSeparator(csvModel.getSeparator())
                .withType(csvModel.getClazz())
                .build().parse();
        return res;
    }

    private MVCModel tryToCreateModel(String path, int modelIndex) throws IOException {
        checkIfItReachEnds(modelIndex);
        CSVModel modelToTry = CSVModel.values()[modelIndex];
        try {
            List<Point> datas = loadFromFile(modelToTry, path);
            MVCModel model =  modelToTry.getModel();
            model.setLines(datas);
            return model;
        } catch (IOException e) {
            return tryToCreateModel(path, modelIndex + 1);
        }
    }

    private static void checkIfItReachEnds(int modelIndex) throws IOException {
        if (modelIndex == CSVModel.values().length) {
            throw new IOException();
        }
    }

    public MVCModel createModelFromFile(String path) throws IOException {
        return tryToCreateModel(path, 0);
    }
}
