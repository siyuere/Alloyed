package part2.service;
import part2.model.Alloy;
import part2.model.Element;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForce implements AlloyOptimizationService  {
    private final AlloyPropertyService alloyPropertyService;

    public BruteForce(AlloyPropertyService alloyPropertyService) {
        this.alloyPropertyService = alloyPropertyService;
    }

    @Override
    public Alloy findBestCreepResistanceWithCost(Alloy alloy, double maxCost) {
        // Brute force approach to find the alloy composition that provides the best creep resistance
        // without exceeding the cost constraint.
        Map<String, Double> bestComposition = null;
        double bestCreepResistance = 0;
        double alloyCost = 0;

        // Generate all possible combinations within the range and step size for each element
        List<Map<String, Double>> combinations = new ArrayList<>();
        generateCombinations(combinations, new HashMap<>(), 0, alloy.getElements());

        // Iterate through all combinations to find the best valid one
        for (Map<String, Double> composition : combinations) {
            double baseElementPercent = 100 - composition.values().stream().mapToDouble(Double::doubleValue).sum();
            if (baseElementPercent < 0) {
                continue;
            }
            double cost = alloyPropertyService.calculateCost(composition, alloy);
            if (cost <= maxCost) {
                double creepResistance = alloyPropertyService.calculateCreepResistance(composition, alloy);
                if (creepResistance > bestCreepResistance) {
                    bestCreepResistance = creepResistance;
                    bestComposition = composition;
                    alloyCost = cost;
                }
            }
        }

        alloy.setCreepResistance(bestCreepResistance);
        alloy.setCost(alloyCost);
        for (Element element : alloy.getElements()) {
            if (bestComposition != null) {
                element.setPercentage(bestComposition.get(element.getName()));
            }
        }
        return alloy;
    }

    private void generateCombinations(List<Map<String, Double>> combinations, Map<String, Double> currentComposition, int index, List<Element> elements) {
        if (index == elements.size()) {
            combinations.add(new HashMap<>(currentComposition));
            return;
        }

        Element element = elements.get(index);
        for (double percent = element.getMinPercent(); percent <= element.getMaxPercent(); percent += element.getStepPercent()) {
            percent = Math.round(percent * 100.0) / 100.0;
            currentComposition.put(element.getName(), percent);
            generateCombinations(combinations, currentComposition, index + 1, elements);
        }
    }
}

