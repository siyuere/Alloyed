package part1.decorator;

import part1.machine.AmMachine;

public class ThermalImagingCamera extends MachineFeatureDecorator {
    public ThermalImagingCamera(AmMachine machine) {
        this.machine = machine;
    }

    @Override
    public String getDescription() {
        return machine.getDescription() + " with Thermal Imaging Camera";
    }

    @Override
    public double cost() {
        return machine.cost() + 54000;
    }

}
