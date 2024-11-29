package part1.features;

import part1.machine.AmMachine;

public class ReducedBuildVolume extends MachineFeatureDecorator {
    AmMachine machine;

    public ReducedBuildVolume(AmMachine machine) {
        this.machine = machine;
    }

    @Override
    public String getDescription() {
        return machine.getDescription() + " with Reduced Build Volume";
    }

    @Override
    public double cost() {
        return machine.cost() + 75000;
    }
}
