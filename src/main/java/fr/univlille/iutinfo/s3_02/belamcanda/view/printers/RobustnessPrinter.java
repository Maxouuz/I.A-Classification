package fr.univlille.iutinfo.s3_02.belamcanda.view.printers;

public class RobustnessPrinter extends Printer<Double> {
    @Override
    public String toString(Double obj) {
        double robustness = Math.round(obj * 100.0 * 100) / 100.0;
        return robustness + "% de robustesse";
    }
}
