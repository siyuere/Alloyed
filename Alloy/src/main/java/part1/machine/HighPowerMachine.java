package part1.machine;

public class HighPowerMachine extends AmMachine {
    public HighPowerMachine() {
        description = "High Power Machine (500W)";
    }

    @Override
    public double cost() {
        return 750000;
    }
}
