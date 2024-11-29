package part2.service;

import part2.model.Alloy;
import part2.model.Element;

public class AlloyOptimizationProgram {
    public static void main(String[] args) {
        // Create elements using the updated Element factory methods
        Element chromium = Element.ofElement("Cr", 2.0911350e+16, 14, 14.5, 22.0, 0.5);
        Element cobalt = Element.ofElement("Co", 7.2380280e+16, 80.5, 0.0, 25.0, 1.0);
        Element niobium = Element.ofElement("Nb", 1.0352738e+16, 42.5, 0.0, 1.5, 0.1);
        Element molybdenum = Element.ofElement("Mo", 8.9124547e+16, 16, 1.5, 6.0, 0.5);
        Element nickel = Element.ofBaseElement("Ni", 8.9);

        // Create an alloy system with Nickel as the base
        Alloy alloy = new Alloy(nickel);

        // Add elements to the alloy
        alloy.addElement(chromium);
        alloy.addElement(cobalt);
        alloy.addElement(niobium);
        alloy.addElement(molybdenum);

        // Find the optimal alloy using the brute force approach
        AlloyPropertyService alloyPropertyService = new AlloyPropertyService();
        BruteForce bruteForce = new BruteForce(alloyPropertyService);
        Alloy optimalAlloy = bruteForce.findBestCreepResistanceWithCost(alloy, 18);
        if (optimalAlloy != null) {
            System.out.println("Optimal Alloy Composition (Brute Force Approach):");
            for (Element el : optimalAlloy.getElements()) {
                System.out.println("Element: " + el.getName() + " Percentage: " + el.getPercentage() + "%");
            }
            System.out.println("Optimal Creep Resistance: " + optimalAlloy.getCreepResistance() + " m^2/s");
            System.out.println("Optimal Cost: £" + optimalAlloy.getCost() + " per kg");
        } else {
            System.out.println("No valid composition found within cost constraint.");
        }
    }
}
