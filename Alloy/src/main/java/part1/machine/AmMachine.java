package part1.machine;

public abstract class AmMachine {
    protected String description;

    public abstract double cost();

    public String getDescription() {
        return description;
    }
}
