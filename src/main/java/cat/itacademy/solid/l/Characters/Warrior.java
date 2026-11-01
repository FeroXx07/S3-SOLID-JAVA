package cat.itacademy.solid.l.Characters;

import cat.itacademy.solid.l.AttackStrategies.SwordStrike;
import cat.itacademy.solid.l.HealthStrategies.StrongPhysical;

public class Warrior extends Character {

    public Warrior() {
        super("Warrior", new StrongPhysical(2), new SwordStrike());
    }
}
