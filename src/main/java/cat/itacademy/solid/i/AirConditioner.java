package cat.itacademy.solid.i;

import cat.itacademy.solid.i.Interfaces.CoolingAction;
import cat.itacademy.solid.i.Interfaces.HeatingAction;

public class AirConditioner extends Machine implements CoolingAction, HeatingAction {
    @Override
    protected void turnOn() {
        System.out.println("AirConditioner is ON");
    }

    @Override
    protected void turnOff() {
        System.out.println("AirConditioner is OFF");
    }

    @Override
    public void cool() {
        System.out.println("AirConditioner is cooling.");
    }

    @Override
    public void heat() {
        System.out.println("AirConditioner is heating.");
    }
}
