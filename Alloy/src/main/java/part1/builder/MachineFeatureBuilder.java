package part1.builder;

import part1.decorator.*;
import part1.machine.AmMachine;
import part1.machine.HighPowerMachine;
import part1.machine.LowPowerMachine;
import part1.machine.MediumPowerMachine;

public class MachineFeatureBuilder {
    private AmMachine machine;

    public MachineFeatureBuilder(AmMachine machine) {
        this.machine = machine;
    }

    private static final class DefaultMachine extends AmMachine {
        @Override
        public double cost() {
            return 0;
        }

        @Override
        public String getDescription() {
            return "";
        }
    }

    public static MachineFeatureBuilder newBuilder() {
        return new MachineFeatureBuilder(new DefaultMachine());
    }

    public MachineFeatureBuilder setMachine(MachineTypeEnum machineType) {
        switch (machineType) {
            case LOW_POWER_MACHINE:
                this.machine = new LowPowerMachine();
                break;
            case MEDIUM_POWER_MACHINE:
                this.machine = new MediumPowerMachine();
                break;
            case HIGH_POWER_MACHINE:
                this.machine = new HighPowerMachine();
                break;
            default:
                throw new IllegalArgumentException("Unknown machine type: " + machineType);
        }
        return this;
    }

    public MachineFeatureBuilder addFeature(FeatureEnum feature) {
        switch (feature) {
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
        if (this.machine instanceof DefaultMachine) {
        throw new IllegalStateException("Machine type must be set before building");
    }
        return this.machine;
    }
}
