package part1.machine;

import part1.decorator.MachineFeatureDecorator;

public class LowPowerMachine extends AmMachine{
    public LowPowerMachine() {
        description = "Low Power Machine (200W)";
    }

    @Override
    public double cost() {
        return 450000;
    }
}
