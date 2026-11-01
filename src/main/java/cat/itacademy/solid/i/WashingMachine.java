package cat.itacademy.solid.i;

import cat.itacademy.solid.i.Interfaces.WashingAction;

public class WashingMachine extends Machine implements WashingAction {

    @Override
    protected void turnOn() {
        System.out.println("WashingMachine is ON");
    }

    @Override
    protected void turnOff() {
        System.out.println("WashingMachine is OFF");
    }

    @Override
    public void wash() {
        System.out.println("WashingMachine is washing clothes.");
    }
}
