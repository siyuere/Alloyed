package part1.decorator;
import part1.machine.AmMachine;

public class PowderRecirculationSystem extends MachineFeatureDecorator {
    public PowderRecirculationSystem(AmMachine machine) {
        this.machine = machine;
    }

    @Override
    public String getDescription() {
        return machine.getDescription() + " with Powder Recirculation System";
    }

    @Override
    public double cost() {
        return machine.cost() + 82000;
    }
}
