package part1.decorator;

import part1.machine.AmMachine;

public abstract class MachineFeatureDecorator extends AmMachine {
    protected AmMachine machine;

    public abstract String getDescription();

    public abstract double cost();


}
