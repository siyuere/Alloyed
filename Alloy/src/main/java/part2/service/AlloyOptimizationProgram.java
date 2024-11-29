package part2.service;

import part2.model.Alloy;
import part2.model.Element;
import part2.utils.AlloyPropertyUtil;

import java.math.BigDecimal;

public class AlloyOptimizationProgram {
    public static void main(String[] args) {
        // Create elements using the updated Element factory methods
        Element chromium = Element.ofElement("Cr", new BigDecimal("2.0911350e+16"), new BigDecimal("14"), new BigDecimal("14.5"), new BigDecimal("22.0"), new BigDecimal("0.5"));
        Element cobalt = Element.ofElement("Co", new BigDecimal("7.2380280e+16"), new BigDecimal("80.5"), new BigDecimal("0.0"), new BigDecimal("25.0"), new BigDecimal("1.0"));
        Element niobium = Element.ofElement("Nb", new BigDecimal("1.0352738e+16"), new BigDecimal("42.5"), new BigDecimal("0.0"), new BigDecimal("1.5"), new BigDecimal("0.1"));
        Element molybdenum = Element.ofElement("Mo", new BigDecimal("8.9124547e+16"), new BigDecimal("16"), new BigDecimal("1.5"), new BigDecimal("6.0"), new BigDecimal("0.5"));
        Element nickel = Element.ofBaseElement("Ni", new BigDecimal("8.9"));

        // Create an alloy system with Nickel as the base
        Alloy alloy = new Alloy(nickel);

        // Add elements to the alloy
        alloy.addElement(chromium);
        alloy.addElement(cobalt);
        alloy.addElement(niobium);
        alloy.addElement(molybdenum);

        // Find the optimal alloy using the brute force approach
        AlloyPropertyUtil alloyPropertyService = new AlloyPropertyUtil();
        BruteForce bruteForce = new BruteForce(alloyPropertyService);
        Alloy optimalAlloy = bruteForce.findBestCreepResistanceWithCost(alloy, 18);
        if (optimalAlloy != null) {
            System.out.println("Optimal Alloy Composition (Brute Force Approach):");
            for (Element el : optimalAlloy.getElements()) {
                System.out.println("Element: " + el.getName() + " Percentage: " + el.getPercentage() + "%");
            }
            System.out.println("Optimal Creep Resistance: " + optimalAlloy.getCreepResistance().toString() + " m^2/s");
            System.out.println("Optimal Cost: £" + optimalAlloy.getCost().toString() + " per kg");
        } else {
            System.out.println("No valid composition found within cost constraint.");
        }
    }
}