package part1.builder;

import part1.decorator.*;
import part1.machine.AmMachine;
import part1.machine.HighPowerMachine;
import part1.machine.LowPowerMachine;
import part1.machine.MediumPowerMachine;

import java.util.Enumeration;

public class MachineFeatureBuilder {
    private AmMachine machine;
    private static AmMachine DEFAULT_MACHINE;

    public MachineFeatureBuilder(AmMachine machine) {
        this.machine = machine;
    }

    private static class defaultMachine extends AmMachine {
        @Override
        public double cost() {
            return 0;
        }

        @Override
        public String getDescription() {
            return '';
        }
    }

    public static MachineFeatureBuilder newBuilder(String type) {
        AmMachine machine = DEFAULT_MACHINE;
        return new MachineFeatureBuilder(machine);
    }

    public MachineFeatureBuilder addFeature(FeatureEnum feature) {
        switch (feature) {
            case LOW_POWER_MACHINE:
                this.machine = new LowPowerMachine();
                break;
            case MEDIUM_POWER_MACHINE:
                this.machine = new MediumPowerMachine();
                break;
            case HIGH_POWER_MACHINE:
                this.machine = new HighPowerMachine();
                break;
            case POWDER_RECIRCULATION_SYSTEM:
                this.machine = new PowderRecirculationSystem(machine);
                break;
            case PHOTODIODES:
                this.machine = new Photodiodes(machine);
                break;
            case QUAD_LASER:
                this.machine = new QuadLaser(machine);
                break;
            case REDUCED_BUILD_VOLUME:
                this.machine = new ReducedBuildVolume(machine);
                break;
            case THERMAL_IMAGING_CAMERA:
                this.machine = new ThermalImagingCamera(machine);
                break;
            default:
                throw new IllegalArgumentException("Unknown feature: " + feature);
        }
        return this;
    }

    public AmMachine build() {
        return this.machine;
    }
}
