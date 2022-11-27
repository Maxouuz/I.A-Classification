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

    public MVCModel createModelFromFile(CSVModel csvModel, String path) throws IOException {
        MVCModel model = csvModel.getModel();
        model.setLines(loadFromFile(csvModel, path));
        return model;
    }
}
