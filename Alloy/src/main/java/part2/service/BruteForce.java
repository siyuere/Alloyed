package part2.service;

import part2.model.Alloy;
import part2.model.Element;
import part2.util.AlloyPropertyUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForce implements AlloyOptimizationService {
    private final AlloyPropertyUtils alloyPropertyService;

    public BruteForce(AlloyPropertyUtils alloyPropertyService) {
        this.alloyPropertyService = alloyPropertyService;
    }

    @Override
    public Alloy findBestCreepResistanceWithCost(Alloy alloy, double maxCost) {
        // Brute force approach to find the alloy composition that provides the best creep resistance
        // without exceeding the cost constraint.
        Map<String, BigDecimal> bestComposition = null;
        BigDecimal bestCreepResistance = BigDecimal.ZERO;
        BigDecimal alloyCost = BigDecimal.ZERO;

        // Generate all possible combinations within the range and step size for each element
        List<Map<String, BigDecimal>> combinations = new ArrayList<>();
        generateCombinations(combinations, new HashMap<>(), 0, alloy.getElements());

        // Iterate through all combinations to find the best valid one
        for (Map<String, BigDecimal> composition : combinations) {
            BigDecimal baseElementPercent = BigDecimal.valueOf(100).subtract(
                    composition.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            if (baseElementPercent.compareTo(BigDecimal.ZERO) < 0) {
                continue;
            }
            BigDecimal cost = alloyPropertyService.calculateCost(composition, alloy);
            if (cost.compareTo(BigDecimal.valueOf(maxCost)) <= 0) {
                BigDecimal creepResistance = alloyPropertyService.calculateCreepResistance(composition, alloy);
                if (creepResistance.compareTo(bestCreepResistance) > 0) {
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

    private void generateCombinations(List<Map<String, BigDecimal>> combinations, Map<String, BigDecimal> currentComposition, int index, List<Element> elements) {
        if (index == elements.size()) {
            combinations.add(new HashMap<>(currentComposition));
            return;
        }

        Element element = elements.get(index);
        BigDecimal stepPercent = element.getStepPercent();
        BigDecimal minPercent = element.getMinPercent();
        BigDecimal maxPercent = element.getMaxPercent();

        for (BigDecimal percent = minPercent; percent.compareTo(maxPercent) <= 0; percent = percent.add(stepPercent)) {
            currentComposition.put(element.getName(), percent);
            generateCombinations(combinations, currentComposition, index + 1, elements);
        }
    }
}

