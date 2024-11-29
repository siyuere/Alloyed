package part2.service;
import part2.model.Alloy;
import part2.model.Element;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class AlloyPropertyService {

    public BigDecimal calculateCreepResistance(Map<String, Double> composition, Alloy alloy) {
        double creepResistance = 0;
        for (Element element : alloy.getElements()) {
            Double percentage = composition.get(element.getName());
            if (percentage != null && percentage >= 0) {
                creepResistance += (element.getCreepCoefficient() * percentage);
            }
        }

        return BigDecimal.valueOf(creepResistance).setScale(2, RoundingMode.HALF_UP);
    }

    public double calculateCost(Map<String, Double> composition, Alloy alloy) {
        double totalCost = 0;
        double baseElementPercent = 100 - composition.values().stream().mapToDouble(Double::doubleValue).sum();

        if (baseElementPercent < 0) {
            throw new IllegalArgumentException("Total composition percentage exceeds 100%");
        }

        totalCost += (alloy.baseElement.getCost() * baseElementPercent) / 100;

        for (Element element : alloy.getElements()) {
            Double percentage = composition.get(element.getName());
            if (percentage != null && percentage >= 0) {
                totalCost += (element.getCost() * percentage) / 100;
            }
        }
        return totalCost;
    }
}
