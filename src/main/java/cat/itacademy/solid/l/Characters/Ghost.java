package cat.itacademy.solid.l.Characters;

import cat.itacademy.solid.l.AttackStrategies.SpookySpell;
import cat.itacademy.solid.l.HealthStrategies.PhysicalImmortality;

public class Ghost extends Character {
    public Ghost() {
        super("Ghost", new PhysicalImmortality(), new SpookySpell());
    }
}
