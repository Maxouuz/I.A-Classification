package fr.univlille.iutinfo.s3_02.belamcanda.distance;

import java.util.HashMap;
import java.util.Map;

public class TempObject {
    private Map<String, Double> normalizedScores;

    public TempObject(double a, double b, double c, double d) {
        normalizedScores = new HashMap<>();
        normalizedScores.put("Tennis", a);
        normalizedScores.put("Foot", b);
        normalizedScores.put("Ping", c);
        normalizedScores.put("Golf", d);
    }

    public Map<String, Double> getNormalizedScores() {
        return normalizedScores;
    }
    
    
}
