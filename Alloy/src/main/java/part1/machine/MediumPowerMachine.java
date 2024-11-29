package part1.machine;

public class MediumPowerMachine extends AmMachine {
    public MediumPowerMachine() {
        description = "Medium Power Machine (400W)";
    }

    @Override
    public double cost() {
        return 550000;
    }
}
