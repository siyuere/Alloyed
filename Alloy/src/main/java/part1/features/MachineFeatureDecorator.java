package part1.features;

import part1.machine.AmMachine;

public abstract class MachineFeatureDecorator extends AmMachine {
    AmMachine machine;

    public abstract String getDescription();

    public abstract double cost();
}
