package part1.machine;

import part1.decorator.MachineFeatureDecorator;

public class MediumPowerMachine extends AmMachine {
    public MediumPowerMachine() {
        description = "Medium Power Machine (400W)";
    }

    @Override
    public double cost() {
        return 550000;
    }
}
