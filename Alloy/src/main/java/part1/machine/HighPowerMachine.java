package part1.machine;

import part1.decorator.MachineFeatureDecorator;

public class HighPowerMachine extends AmMachine {
    public HighPowerMachine() {
        description = "High Power Machine (500W)";
    }

    @Override
    public double cost() {
        return 750000;
    }
}
