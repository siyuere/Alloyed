package part1.features;

import part1.machine.AmMachine;

public class ThermalImagingCamera extends MachineFeatureDecorator {
    AmMachine machine;

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
