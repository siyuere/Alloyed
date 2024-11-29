package part1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import part1.builder.MachineFeatureBuilder;
import part1.machine.AmMachine;

import static org.junit.Assert.assertEquals;

class AmMachineTest {
    private MachineFeatureBuilder mockBuilder;

    @Test
    void testMediumPowerMachineWithFeatures() {
        mockBuilder = MachineFeatureBuilder.createMachine("medium");

        AmMachine mockMachine = mockBuilder.addFeature("Reduced Build Volume")
                                    .addFeature("Quad Laser")
                                    .addFeature("Powder Recirculation System")
                                    .build();

        Assertions.assertEquals(932000, mockMachine.cost(), 0);
        Assertions.assertEquals("Medium Power Machine (400W) with Reduced Build Volume with Quad Laser System with Powder Recirculation System", mockMachine.getDescription());
    }
}
