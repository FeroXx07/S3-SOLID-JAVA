package cat.itacademy.solid.i;

import cat.itacademy.solid.i.Interfaces.CoolingAction;
import cat.itacademy.solid.i.Interfaces.HeatingAction;
import org.junit.jupiter.api.Test;

import static cat.itacademy.solid.ReflectionUtility.assertAllImplementationsSupport;
import static org.assertj.core.api.Assertions.assertThat;

public class MachineTest {
    
    @Test
    void machineShouldBeAbstract() {
        assertThat(Machine.class).isAbstract();
    }

    @Test
    void subclassesShouldExtendMachine() {
        assertThat(AirConditioner.class).isAssignableTo(Machine.class);
        assertThat(WashingMachine.class).isAssignableTo(Machine.class);
    }

    @Test
    void interfaceSubclassAreSupportedOperations() throws Exception {
        assertAllImplementationsSupport(CoolingAction.class, CoolingAction::cool);
        assertAllImplementationsSupport(HeatingAction.class, HeatingAction::heat);
        assertAllImplementationsSupport(WashingMachine.class, WashingMachine::wash);
    }
}
