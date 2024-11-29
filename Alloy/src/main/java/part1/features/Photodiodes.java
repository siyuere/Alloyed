package part1.features;

import part1.machine.AmMachine;

public class Photodiodes extends MachineFeatureDecorator {
    AmMachine machine;

    public Photodiodes(AmMachine machine) {
        this.machine = machine;
    }

    @Override
    public String getDescription() {
        return machine.getDescription() + " with Photodiodes";
    }

    @Override
    public double cost() {
        return machine.cost() + 63000;
    }
}
