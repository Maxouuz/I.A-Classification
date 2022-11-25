package fr.univlille.iutinfo.s3_02.belamcanda.model.loader;

import com.opencsv.bean.CsvToBeanBuilder;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SpecifiedLoader<T extends Point> {
    protected List<Point> loadFromFile(Class<? extends Point> clazz, String path, char separator) throws IOException {
        List<Point> res;
        res = new CsvToBeanBuilder<Point>(Files.newBufferedReader(Paths.get(path)))
                .withSeparator(separator)
                .withType(clazz)
                .build().parse();
        return res;
    }
}
