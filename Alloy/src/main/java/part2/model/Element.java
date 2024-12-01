package part2.model;

import java.math.BigDecimal;

public class Element {
    private String name;
    private BigDecimal creepCoefficient;
    private BigDecimal cost;
    private BigDecimal minPercent;
    private BigDecimal maxPercent;
    private BigDecimal percentage;
    private BigDecimal stepPercent;

    public String getName() {
        return name;
    }

    public BigDecimal getCreepCoefficient() {
        return creepCoefficient;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getMinPercent() {
        return minPercent;
    }

    public BigDecimal getMaxPercent() {
        return maxPercent;
    }

    public BigDecimal getStepPercent() {
        return stepPercent;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public static Element ofElement(String name, BigDecimal creepCoefficient, BigDecimal cost, BigDecimal minPercent, BigDecimal maxPercent, BigDecimal stepPercent) {
        Element element = new Element();
        element.name = name;
        element.creepCoefficient = creepCoefficient;
        element.cost = cost;
        element.minPercent = minPercent;
        element.maxPercent = maxPercent;
        element.stepPercent = stepPercent;
        return element;
    }

    public static Element ofBaseElement(String name, BigDecimal cost) {
        Element element = new Element();
        element.name = name;
        element.cost = cost;
        return element;
    }
}
