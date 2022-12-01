package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class CSVLoader {
    private static final Map<List<String>, CSVModel> CSVMODELFROMCOLUMNS;

    static {
        CSVMODELFROMCOLUMNS = new HashMap<>();
        for (CSVModel model: CSVModel.values()) {
            CSVMODELFROMCOLUMNS.put(model.getColumnsName(), model);
        }
    }

    public List<Point> loadFromFile(CSVModel csvModel, String path) throws IOException {
        List<Point> res;
        if (!fileIsValid(csvModel, path)) {
            throw new IOException("Les colonnes du fichier CSV ne correspondent pas au modèle chargé");
        }
        res = new CsvToBeanBuilder<Point>(Files.newBufferedReader(Paths.get(path)))
                .withSeparator(csvModel.getSeparator())
                .withType(csvModel.getPointClass())
                .build().parse();
        return res;
    }

    private boolean fileIsValid(CSVModel csvModel, String path) throws IOException {
        return csvModel.getColumnsName().equals(getHeader(csvModel.getSeparator(), path));
    }

    public CSVModel getCSVModelFromFile(String path) throws IOException {
        List<String> fileHeader = getHeader(',', path);
        if (!CSVMODELFROMCOLUMNS.containsKey(fileHeader)) {
            throw new IOException("Les colonnes du fichier CSV ne correspondent à aucun modèle existant");
        }
        return CSVMODELFROMCOLUMNS.get(fileHeader);
    }

    private List<String> getHeader(char separator, String path) throws IOException {
        try (CSVReader csvReader = getCsvReaderBuilder(separator, path).build()) {
            return List.of(csvReader.readNext());
        } catch (CsvValidationException e) {
            return new ArrayList<>();
        }
    }

    private static CSVReaderBuilder getCsvReaderBuilder(char separator, String path) throws IOException {
        return new CSVReaderBuilder(Files.newBufferedReader(Path.of(path)))
                        .withCSVParser(new CSVParserBuilder()
                        .withSeparator(separator)
                        .build());
    }

    public MVCModel createModelFromFile(String path) throws IOException {
        CSVModel csvModel = getCSVModelFromFile(path);
        MVCModel model = csvModel.getModel();
        model.setLines(loadFromFile(csvModel, path));
        return model;
    }
}
