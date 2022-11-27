package fr.univlille.iutinfo.s3_02.belamcanda.scenario;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.Point;
import fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.ManhattanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.RandomDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVModel;
import fr.univlille.iutinfo.s3_02.belamcanda.view.printers.CategorizerPrinter;
import fr.univlille.iutinfo.s3_02.belamcanda.view.printers.ModelPrinter;
import fr.univlille.iutinfo.s3_02.belamcanda.view.printers.RobustnessPrinter;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Scenario {
    static final String DATA_PATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
    private static MVCModel model;
    private static Categorizer categorizer;
    private static int titleIndex = 1;

    public static void main(String[] args) throws IOException {
        // Création du modèle et du catégoriseur
        printTitle("INITIALISATION");
        initClasses();

        // Ajout des données de tests
        printTitle("AJOUT DES DONNÉES À CLASSIFIER");
        addDataToClassify();

        printTitle("DISTANCE EUCLIDIENNE");
        printTwoRobustness();

        // Modification du catégoriseur
        printTitle("DISTANCE DE MANHATTAN");
        categorizer.setDistanceMethod(new ManhattanDistance());
        printTwoRobustness();

        // Modification du catégoriseur
        printTitle("DISTANCE ALÉATOIRE");
        categorizer.setDistanceMethod(new RandomDistance());
        printTwoRobustness();
    }

    private static void printTitle(String title) {
        System.out.printf("\n=== %s - %s ===\n%n", titleIndex++, title);
    }

    private static void printTwoRobustness() {
        // Validation à partir des données de tests
        System.out.println("- Validation avec données de test (k = 3)\n");
        categorizer.setK(3);
        getRobustnessWithTestDatas();

        // Validation à partir des données de tests
        System.out.println("\n- Validation avec données de test (k = 10)\n");
        categorizer.setK(10);
        getRobustnessWithTestDatas();

        // Validation à partir de la cross-validationv
        System.out.println("\n- Cross-validation (k = 3)\n");
        categorizer.setK(3);
        getRobustnessWithCrossValidation();
    }

    private static void getRobustnessWithCrossValidation() {
        new RobustnessPrinter().print(categorizer.getRobustnessByCrossValidation());
    }

    private static void getRobustnessWithTestDatas() {
        new RobustnessPrinter().print(categorizer.getRobustness());
    }

    private static void addDataToClassify() throws IOException {
        List<Point> toClassify = new CSVLoader().loadFromFile(CSVModel.POKEMON, DATA_PATH + "pokemon_test.csv");
        model.addDataToClassify(toClassify);
        new ModelPrinter().print(model);
    }

    private static void initClasses() throws IOException {
        model = new CSVLoader().createModelFromFile(CSVModel.POKEMON, DATA_PATH + "pokemon_train.csv");
        categorizer = new Categorizer(model, new EuclideanDistance(), 3);
        new ModelPrinter().print(model);
        new CategorizerPrinter().print(categorizer);
    }
}