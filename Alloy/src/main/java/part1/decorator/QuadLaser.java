package part1.decorator;

import part1.machine.AmMachine;

public class QuadLaser extends MachineFeatureDecorator {
    public QuadLaser(AmMachine machine) {
        this.machine = machine;
    }

    @Override
    public String getDescription() {
        return machine.getDescription() + " with Quad Laser System";
    }

    @Override
    public double cost() {
        return machine.cost() + 225000;
    }
}
