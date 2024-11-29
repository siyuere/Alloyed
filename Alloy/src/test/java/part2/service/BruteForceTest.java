package part2.service;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import part2.model.Alloy;
import part2.model.Element;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static part2.model.Element.ofBaseElement;
import static part2.model.Element.ofElement;

class BruteForceTest {
    private final AlloyPropertyService MockAlloyPropertyService = new AlloyPropertyService();
    private final BruteForce MockBruteForce = new BruteForce(MockAlloyPropertyService);
    private Alloy testAlloy;

    @BeforeEach
    public void setUp() {
        Element mockBaseElement = ofBaseElement("Ni", new BigDecimal("8.9"));  // Nickel as the base element with cost 8.9 £/kg
        Element chromium = ofElement("Cr", new BigDecimal("2.0911350E16"), new BigDecimal("14.0"), new BigDecimal("14.5"), new BigDecimal("22.0"), new BigDecimal("0.50"));  // Chromium with cost 14 £/kg
        Element cobalt = ofElement("Co", new BigDecimal("7.2380280E16"), new BigDecimal("80.5"), new BigDecimal("0.0"), new BigDecimal("25.0"), new BigDecimal("1.0"));  // Cobalt with cost 80.5 £/kg
        Element niobium = ofElement("Nb", new BigDecimal("1.0352738E16"), new BigDecimal("42.5"), new BigDecimal("0.0"), new BigDecimal("1.5"), new BigDecimal("0.1"));  // Niobium with cost 42.5 £/kg
        Element molybdenum = ofElement("Mo", new BigDecimal("8.9124547E16"), new BigDecimal("16.0"), new BigDecimal("1.5"), new BigDecimal("6.0"), new BigDecimal("0.5"));  // Molybdenum with cost 16 £/kg

        testAlloy = new Alloy(mockBaseElement);
        testAlloy.addElement(chromium);
        testAlloy.addElement(cobalt);
        testAlloy.addElement(niobium);
        testAlloy.addElement(molybdenum);
    }

    @Test
    void testFindBestCreepResistanceWithCost() {
        Alloy optimalAlloy = MockBruteForce.findBestCreepResistanceWithCost(testAlloy, 18);
        BigDecimal actualCreepResistance = optimalAlloy.getCreepResistance();
        BigDecimal expectedCreepResistance = new BigDecimal("1.72999E18");

        assertEquals(expectedCreepResistance, actualCreepResistance);
    }
}
