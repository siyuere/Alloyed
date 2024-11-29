package part2.utils;

import part2.model.Alloy;
import part2.model.Element;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;

public class AlloyPropertyUtil {
    // static: bond to class
    private static final DecimalFormat SCIENTIFIC_FORMAT = new DecimalFormat("0.00000E0");

    /**
     * Calculate the creep resistance of the given alloy composition.
     *
     * @param composition the composition of the alloy
     * @param alloy the alloy object
     * @return the calculated creep resistance
     */
    public BigDecimal calculateCreepResistance(Map<String, BigDecimal> composition, Alloy alloy) {
        if (composition == null || alloy == null) {
            throw new IllegalArgumentException("Composition and alloy must not be null");
        }

        BigDecimal creepResistance = BigDecimal.ZERO;
        for (Element element : alloy.getElements()) {
            BigDecimal percentage = composition.get(element.getName());
            if (percentage != null && percentage.compareTo(BigDecimal.ZERO) >= 0) {
                creepResistance = creepResistance.add(element.getCreepCoefficient().multiply(percentage));
            }
        }
        return new BigDecimal(SCIENTIFIC_FORMAT.format(creepResistance));
    }

    /**
     * Calculate the cost of the given alloy composition.
     *
     * @param composition the composition of the alloy
     * @param alloy the alloy object
     * @return the calculated cost
     */
    public BigDecimal calculateCost(Map<String, BigDecimal> composition, Alloy alloy) {
        if (composition == null || alloy == null) {
            throw new IllegalArgumentException("Composition and alloy must not be null");
        }

        BigDecimal totalCost = BigDecimal.ZERO;
        BigDecimal baseElementPercent = BigDecimal.valueOf(100).subtract(
                composition.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add)
        );

        if (baseElementPercent.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Total composition percentage exceeds 100%");
        }

        totalCost = totalCost.add(alloy.getBaseElement().getCost().multiply(baseElementPercent).divide(BigDecimal.valueOf(100)));

        for (Element element : alloy.getElements()) {
            BigDecimal percentage = composition.get(element.getName());
            if (percentage != null && percentage.compareTo(BigDecimal.ZERO) >= 0) {
                totalCost = totalCost.add(element.getCost().multiply(percentage).divide(BigDecimal.valueOf(100)));
            }
        }
        return new BigDecimal(SCIENTIFIC_FORMAT.format(totalCost));
    }
}