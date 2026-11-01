package cat.itacademy.solid.l.AttackStrategies;

import cat.itacademy.solid.l.Characters.Character;

public class SpookySpell implements AttackStrategy {
    @Override
    public void attack(Character from, Character to) {
        System.out.println("The " + from.getName() + " casts a spooky spell to " + to.getName());
        to.takeDamage(10);
    }
}
