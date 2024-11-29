package part2.service;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part2.model.Alloy;
import part2.model.Element;
import part2.util.AlloyPropertyUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static part2.model.Element.ofBaseElement;
import static part2.model.Element.ofElement;

public class AlloyPropertyServiceTest {
    private Alloy testAlloy;
    private AlloyPropertyUtils mockAlloyPropertyService;
    private DecimalFormat mockScientificFormat;

    @BeforeEach
    public void setUp() {
        mockAlloyPropertyService = new AlloyPropertyUtils();
        Element mockBaseElement = ofBaseElement("Ni", new BigDecimal("8.9"));  // Nickel as the base element with cost 8.9 £/kg
        Element chromium = ofElement("Cr", new BigDecimal("2.0911350E16"), new BigDecimal("14.0"), new BigDecimal("14.5"), new BigDecimal("22.0"), new BigDecimal("0.50"));  // Chromium with cost 14 £/kg
        Element cobalt = ofElement("Co", new BigDecimal("7.2380280E16"), new BigDecimal("80.5"), new BigDecimal("0.0"), new BigDecimal("25.0"), new BigDecimal("1.0"));  // Cobalt with cost 80.5 £/kg
        Element niobium = ofElement("Nb", new BigDecimal("1.0352738E16"), new BigDecimal("42.5"), new BigDecimal("0.0"), new BigDecimal("1.5"), new BigDecimal("0.1"));  // Niobium with cost 42.5 £/kg
        Element molybdenum = ofElement("Mo", new BigDecimal("8.9124547E16"), new BigDecimal("16.0"), new BigDecimal("1.5"), new BigDecimal("6.0"), new BigDecimal("0.5"));  // Molybdenum with cost 16 £/kg
        mockScientificFormat = new DecimalFormat("0.000E0");

        testAlloy = new Alloy(mockBaseElement);
        testAlloy.addElement(chromium);
        testAlloy.addElement(cobalt);
        testAlloy.addElement(niobium);
        testAlloy.addElement(molybdenum);
    }

    @Test
    public void testCalculateCreepResistanceGroup1() {
        Map<String, BigDecimal> composition = new HashMap<>();
        composition.put("Cr", new BigDecimal("15.0"));
        composition.put("Co", new BigDecimal("10.0"));
        composition.put("Nb", new BigDecimal("1.0"));
        composition.put("Mo", new BigDecimal("2.0"));
        BigDecimal expectedCreepResistance = new BigDecimal("1.226E18");

        BigDecimal actualCreepResistance = new BigDecimal(mockScientificFormat.format(mockAlloyPropertyService.calculateCreepResistance(composition, testAlloy)));

        Assert.assertEquals(expectedCreepResistance, actualCreepResistance);
    }

    @Test
    public void testCalculateCreepResistanceGroup2() {
        Map<String, BigDecimal> composition = new HashMap<>();
        composition.put("Cr", new BigDecimal("20.0"));
        composition.put("Co", new BigDecimal("0.0"));
        composition.put("Nb", new BigDecimal("0.0"));
        composition.put("Mo", new BigDecimal("1.5"));
        BigDecimal expectedCreepResistance = new BigDecimal("5.519E17");

        BigDecimal actualCreepResistance = new BigDecimal(mockScientificFormat.format(mockAlloyPropertyService.calculateCreepResistance(composition, testAlloy)));

        Assert.assertEquals(expectedCreepResistance, actualCreepResistance);
    }

    @Test
    public void testCalculateCreepResistanceGroup3() {
        Map<String, BigDecimal> composition = new HashMap<>();
        composition.put("Cr", new BigDecimal("22.0"));
        composition.put("Co", new BigDecimal("25.0"));
        composition.put("Nb", new BigDecimal("1.5"));
        composition.put("Mo", new BigDecimal("6.0"));
        BigDecimal expectedCreepResistance = new BigDecimal("2.820E18");

        BigDecimal actualCreepResistance = new BigDecimal(mockScientificFormat.format(mockAlloyPropertyService.calculateCreepResistance(composition, testAlloy)));

        Assert.assertEquals(expectedCreepResistance, actualCreepResistance);
    }

    @Test
    public void testCalculateCostWithInvalidComposition() {
        Map<String, BigDecimal> composition = new HashMap<>();
        composition.put("Element1", new BigDecimal("60.0"));
        composition.put("Element2", new BigDecimal("50.0"));

        assertThrows(IllegalArgumentException.class, () -> {
            mockAlloyPropertyService.calculateCost(composition, testAlloy);
        });
    }
}
