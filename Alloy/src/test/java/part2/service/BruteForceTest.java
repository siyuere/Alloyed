package part2.service;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import part2.model.Alloy;
import part2.model.Element;

public class BruteForceTest {
    private  final AlloyPropertyService MockAlloyPropertyService = new AlloyPropertyService();
    private final BruteForce MockBruteForce = new BruteForce(MockAlloyPropertyService);
    private final Element MockBaseElement = new Element();
    private final Alloy MockAlloy = new Alloy(MockBaseElement);

    @BeforeEach
    public void setUp() {

    }
}
