package fr.univlille.iutinfo.s3_02.belamcanda.scenario;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.implementations.pokemon.PokemonPoint;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import fr.univlille.iutinfo.s3_02.belamcanda.view.printers.CategorizerPrinter;
import fr.univlille.iutinfo.s3_02.belamcanda.view.printers.ModelPrinter;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class Scenario {
    static final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;

    public static void main(String[] args) throws IOException {
        MVCModel model = new CSVLoader().createModelFromFile(CSVModel.POKEMON, DATA_PATH + "pokemon_train.csv");
        /**
         * je charge
         * je mets des données test
         * j'affiche le categorizer
         * je categorise ma donnée de test
         *
         */
        Collection<Point> testData = new CSVLoader().loadFromFile( CSVModel.fromClazz(model.pointClass()), DATA_PATH + "pokemon_test.csv");
        model.addDataToClassify(testData);
        new ModelPrinter().print(model);
        Categorizer cat = new Categorizer(model, new EuclideanDistance(), 5);
        new CategorizerPrinter().print(cat);
        System.out.println("Cross validation : " + cat.getRobustness());
        System.out.println("A partir du jeu de test : " + cat.getRobustness(testData));
    }
}
