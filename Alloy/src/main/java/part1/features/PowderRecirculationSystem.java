package part1.features;
import part1.machine.AmMachine;

public class PowderRecirculationSystem extends MachineFeatureDecorator {
    AmMachine machine;

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
