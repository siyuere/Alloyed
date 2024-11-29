package part1.decorator;

import part1.machine.AmMachine;

public class Photodiodes extends MachineFeatureDecorator {
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
