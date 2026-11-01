package cat.itacademy.solid.l.AttackStrategies;

import cat.itacademy.solid.l.Characters.Character;

public class SwordStrike implements AttackStrategy {
    @Override
    public void attack(Character from, Character to) {
        System.out.println("The " + from.getName() + " strikes with a sword to " + to.getName());
        to.takeDamage(10);
    }
}
