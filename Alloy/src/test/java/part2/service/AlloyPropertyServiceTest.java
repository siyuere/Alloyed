package part2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part2.model.Alloy;
import part2.model.Element;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static part2.model.Element.ofBaseElement;
import static part2.model.Element.ofElement;

public class AlloyPropertyServiceTest {
    private Alloy testAlloy;
    private AlloyPropertyService mockAlloyPropertyService;

    @BeforeEach
    public void setUp() {
        mockAlloyPropertyService = new AlloyPropertyService();
        Element mockBaseElement = ofBaseElement("Ni", 8.9);  // Nickel as the base element with cost 8.9 £/kg
        Element chromium = ofElement("Cr", 2.0911350E16,14.0 ,14.5, 22.0, 0.50);  // Chromium with cost 14 £/kg
        Element cobalt = ofElement("Co", 7.2380280E16, 80.5,0.0, 25.0, 1.0);  // Cobalt with cost 80.5 £/kg
        Element niobium = ofElement("Nb", 1.0352738E16, 42.5,0.0, 1.5, 0.1);  // Niobium with cost 42.5 £/kg
        Element molybdenum = ofElement("Mo", 8.9124547E16,16.0, 1.5, 6.0, 0.5);  // Molybdenum with cost 16 £/kg

        testAlloy = new Alloy(mockBaseElement);
        testAlloy.addElement(chromium);
        testAlloy.addElement(cobalt);
        testAlloy.addElement(niobium);
        testAlloy.addElement(molybdenum);
    }

    @Test
    public void testCalculateCreepResistanceGroup1() {
        Map<String, Double> composition = new HashMap<>();
        composition.put("Cr", 15.0);
        composition.put("Co", 10.0);
        composition.put("Nb", 1.0);
        composition.put("Mo", 2.0);

        double creepResistance = mockAlloyPropertyService.calculateCreepResistance(composition, testAlloy);
        assertEquals(1.226E18, creepResistance, 0.01);
    }

    @Test
    public void testCalculateCreepResistanceGroup2() {
        Map<String, Double> composition = new HashMap<>();
        composition.put("Cr", 20.0);
        composition.put("Co", 0.0);
        composition.put("Nb", 0.0);
        composition.put("Mo", 1.5);

        double creepResistance = mockAlloyPropertyService.calculateCreepResistance(composition, testAlloy);
        assertEquals(5.519E17, creepResistance, 0.01);
    }

    @Test
    public void testCalculateCreepResistanceGroup3() {
        Map<String, Double> composition = new HashMap<>();
        composition.put("Cr", 22.0);
        composition.put("Co", 25.0);
        composition.put("Nb", 1.50);
        composition.put("Mo", 6.00);

        double creepResistance = mockAlloyPropertyService.calculateCreepResistance(composition, testAlloy);
        assertEquals(2.820E18, creepResistance, 0.01);
    }
    @Test
    public void testCalculateCostWithInvalidComposition() {
        Map<String, Double> composition = new HashMap<>();
        composition.put("Element1", 60.0);
        composition.put("Element2", 50.0);

        assertThrows(IllegalArgumentException.class, () -> {
            mockAlloyPropertyService.calculateCost(composition, testAlloy);
        });
    }
}
