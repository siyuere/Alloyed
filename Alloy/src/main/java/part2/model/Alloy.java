package part2.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Alloy {
    private Element baseElement;
    private List<Element> elements;
    private BigDecimal creepResistance;
    private BigDecimal cost;

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

    public void setCreepResistance(BigDecimal creepResistance) {
        this.creepResistance = creepResistance;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCreepResistance() {
        return creepResistance;
    }

    public Element getBaseElement() {
        return baseElement;
    }
}
