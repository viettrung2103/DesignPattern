package org.example;

import java.util.HashMap;
import java.util.Map;

public class RecommendationRegistry {
    private Map<String, Recommendation> prototypes = new
            HashMap<>();

    public void register(String name, Recommendation recommendation) {
        prototypes.put(name, recommendation);
    }

    public Recommendation clone(String name) {
        Recommendation prototype = prototypes.get(name);
        if (prototype == null) throw new IllegalArgumentException("Prototype not found: " + name);
        return prototype.clone();
    }

    public Map<String, Recommendation> getPrototypes() {
        return prototypes;
    }
}