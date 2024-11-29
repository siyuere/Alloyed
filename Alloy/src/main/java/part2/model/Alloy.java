package part2.model;

import java.util.ArrayList;
import java.util.List;

public class Alloy {
    public Element baseElement;
    private final List<Element> elements;
    private double creepResistance;
    private double cost;

    public List<Element> getElements() {
            return elements;
        }

    public Alloy(Element baseElement) {
        this.baseElement = baseElement;
        this.elements = new ArrayList<>();
    }

    public void addElement(Element element) {
        this.elements.add(element);
    }

    public void setCreepResistance(double creepResistance) {
        this.creepResistance = creepResistance;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCreepResistance() {
        return creepResistance;
    }
}
