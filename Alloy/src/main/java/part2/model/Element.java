package part2.model;

public class Element {
    private String name;
    private double creepCoefficient;
    private double cost;
    private double minPercent;
    private double maxPercent;
    private double percentage;

    public String getName() {
        return name;
    }

    public double getCreepCoefficient() {
        return creepCoefficient;
    }

    public double getCost() {
        return cost;
    }

    public double getMinPercent() {
        return minPercent;
    }

    public double getMaxPercent() {
        return maxPercent;
    }

    public double getStepPercent() {
        return stepPercent;
    }

    private double stepPercent;

    public static Element ofElement(String name, double creepCoefficient, double cost, double minPercent, double maxPercent, double stepPercent) {
        Element element = new Element();
        element.name = name;
        element.creepCoefficient = creepCoefficient;
        element.cost = cost;
        element.minPercent = minPercent;
        element.maxPercent = maxPercent;
        element.stepPercent = stepPercent;
        return element;
    }

    public static Element ofBaseElement(String name,  double cost) {
        Element element = new Element();
        element.name = name;
        element.cost = cost;
        return element;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
