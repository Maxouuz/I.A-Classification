package fr.univlille.iutinfo.s3_02.belamcanda.scenario;

import fr.univlille.iutinfo.s3_02.belamcanda.model.MVCModel;
import fr.univlille.iutinfo.s3_02.belamcanda.model.categorizer.Categorizer;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.EuclideanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.ManhattanDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.distance.RandomDistance;
import fr.univlille.iutinfo.s3_02.belamcanda.model.loader.CSVLoader;
import fr.univlille.iutinfo.s3_02.belamcanda.view.printers.CategorizerPrinter;
import fr.univlille.iutinfo.s3_02.belamcanda.view.printers.ModelPrinter;
import fr.univlille.iutinfo.s3_02.belamcanda.view.printers.RobustnessPrinter;

import java.io.File;
import java.io.IOException;

public class Scenario {
    private static final String DATAPATH = System.getProperty("user.dir") + File.separator + "data" + File.separator;
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

        printTitle("DISTANCE ALÉATOIRE AUTRE MODÈLE (cross-validation)");
        model = new CSVLoader().createModelFromFile(DATAPATH + "iris.csv");
        categorizer = new Categorizer(model, new RandomDistance(), 3);
        getRobustnessWithCrossValidation();
        printConclusionIrisCrossValidation();
    }

    private static void printConclusionIrisCrossValidation() {
        String conclusion = "On devrait trouver un nombre égal à environ 33%, " +
                            "le résultat est logique vu que nous avons 3 types d'Iris (donc environ 1/3 de probabilités), " +
                            "et que les différentes catégories sont présentes plus équitablement que par rapport " +
                            "aux pokémons légendaires et non légendaires";
        System.out.println(conclusion);
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

        // Validation à partir de la cross-validation
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
        model.setTestData(DATAPATH + "pokemon_test.csv");
        new ModelPrinter().print(model);
    }

    private static void initClasses() throws IOException {
        model = new CSVLoader().createModelFromFile(DATAPATH + "pokemon_train.csv");
        categorizer = new Categorizer(model, new EuclideanDistance(), 3);
        new ModelPrinter().print(model);
        new CategorizerPrinter().print(categorizer);
    }
}
