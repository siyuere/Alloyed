package part1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import part1.builder.FeatureEnum;
import part1.builder.MachineFeatureBuilder;
import part1.builder.MachineTypeEnum;
import part1.machine.AmMachine;

import static org.junit.Assert.assertEquals;

class AmMachineTest {
    private MachineFeatureBuilder mockBuilder;

    @Test
    void testMediumPowerMachineWithFeatures() {
        mockBuilder = MachineFeatureBuilder.newBuilder();

        AmMachine mockMachine = mockBuilder.setMachine(MachineTypeEnum.MEDIUM_POWER_MACHINE)
                                    .addFeature(FeatureEnum.REDUCED_BUILD_VOLUME)
                                    .addFeature(FeatureEnum.QUAD_LASER)
                                    .addFeature(FeatureEnum.POWDER_RECIRCULATION_SYSTEM)
                                    .build();

        Assertions.assertEquals(932000, mockMachine.cost(), 0);
        Assertions.assertEquals("Medium Power Machine (400W) with Reduced Build Volume with Quad Laser System with Powder Recirculation System", mockMachine.getDescription());
    }
}
