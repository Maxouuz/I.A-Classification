package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class CSVLoader {
    private static final Map<List<String>, CSVModel> csvModelFromColumns;

    static {
        csvModelFromColumns = new HashMap<>();
        for (CSVModel model: CSVModel.values()) {
            csvModelFromColumns.put(model.getColumnsName(), model);
        }
    }

    public List<Point> loadFromFile(CSVModel csvModel, String path) throws IOException {
        List<Point> res;
        if (!fileIsValid(csvModel, path)) {
            throw new IOException();
        }
        res = new CsvToBeanBuilder<Point>(Files.newBufferedReader(Paths.get(path)))
                .withSeparator(csvModel.getSeparator())
                .withType(csvModel.getClazz())
                .build().parse();
        return res;
    }

    private boolean fileIsValid(CSVModel csvModel, String path) throws IOException {
        return csvModel.getColumnsName().equals(getHeader(csvModel.getSeparator(), path));
    }

    public CSVModel getCSVModelFromFile(String path) throws IOException {
        List<String> fileHeader = getHeader(',', path);
        if (!csvModelFromColumns.containsKey(fileHeader)) {
            throw new IOException();
        }
        return csvModelFromColumns.get(fileHeader);
    }

    private List<String> getHeader(char separator, String path) throws IOException {
        try (CSVReader csvReader = getCsvReaderBuilder(separator, path).build()) {
            return List.of(csvReader.readNext());
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private static CSVReaderBuilder getCsvReaderBuilder(char separator, String path) throws FileNotFoundException {
        return new CSVReaderBuilder(new FileReader(path))
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
