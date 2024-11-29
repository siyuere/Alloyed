package part1.features;

import part1.machine.AmMachine;
import part1.machine.HighPowerMachine;
import part1.machine.LowPowerMachine;
import part1.machine.MediumPowerMachine;

public class MachineFeatureBuilder {
    private AmMachine machine;

    public MachineFeatureBuilder(AmMachine machine) {
        this.machine = machine;
    }

    public static MachineFeatureBuilder createMachine(String type) {
        AmMachine machine;
        switch (type.toLowerCase()) {
            case "low":
                machine = new LowPowerMachine();
                break;
            case "medium":
                machine = new MediumPowerMachine();
                break;
            case "high":
                machine = new HighPowerMachine();
                break;
            default:
                throw new IllegalArgumentException("Unknown machine type: " + type);
        }
        return new MachineFeatureBuilder(machine);
    }

    public MachineFeatureBuilder addFeature(String feature) {
        switch (feature) {
            case "Powder Recirculation System":
                this.machine = new PowderRecirculationSystem(machine);
                break;
            case "Photodiodes":
                this.machine = new Photodiodes(machine);
                break;
            case "Quad Laser":
                this.machine = new QuadLaser(machine);
                break;
            case "Reduced Build Volume":
                this.machine = new ReducedBuildVolume(machine);
                break;
            case "Thermal Imaging Camera":
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
