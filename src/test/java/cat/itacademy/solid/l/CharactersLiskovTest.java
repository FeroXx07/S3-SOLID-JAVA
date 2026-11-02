package cat.itacademy.solid.l;

import cat.itacademy.solid.l.AttackStrategies.SpookySpell;
import cat.itacademy.solid.l.Characters.Character;
import cat.itacademy.solid.l.Characters.Ghost;
import cat.itacademy.solid.l.Characters.Warrior;
import cat.itacademy.solid.l.HealthStrategies.StrongPhysical;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CharactersLiskovTest {

    @Test
    void mainLiskovTest(){
        Character baseCharacter = new Character("Fat wizard", new StrongPhysical(3), new SpookySpell());
        List<Character> subclassCharacters = new ArrayList<>(List.of(new Ghost(), new Warrior()));

        for (Character child : subclassCharacters)
        {
            Throwable thrownA = catchThrowable(() -> child.attack(baseCharacter));
            assertThat(thrownA).isNull();

            Throwable thrownB = catchThrowable(() -> baseCharacter.attack(child));
            assertThat(thrownB).isNull();
        }
    }
}
