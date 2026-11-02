package cat.itacademy.solid.o;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InstrumentTest {

    @Test
    void instrumentsShouldBeSubclass(){
        assertThat(Drums.class).isAssignableTo(Instrument.class);
        assertThat(Guitar.class).isAssignableTo(Instrument.class);
        assertThat(Piano.class).isAssignableTo(Instrument.class);
    }
}
