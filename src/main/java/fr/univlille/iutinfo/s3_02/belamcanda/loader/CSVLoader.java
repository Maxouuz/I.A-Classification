package fr.univlille.iutinfo.s3_02.belamcanda.loader;

import com.opencsv.bean.CsvToBeanBuilder;
import fr.univlille.iutinfo.s3_02.belamcanda.beans.PokemonBean;


import java.io.File;
import java.util.List;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVLoader<T> {
    String DATA_DIR = System.getProperty("user.dir") + File.separator + "data" + File.separator ;
    public List<T> loadFromFile(Class<T> clazz, String path, char separator) throws IOException {
        List<T> res;
        res = new CsvToBeanBuilder<T>(Files.newBufferedReader(Paths.get(path)))
                .withSeparator(separator)
                .withType(clazz)
                .build().parse();
            System.out.println(res);
            return res;
    }

}
