package cat.itacademy.solid.l.AttackStrategies;

import cat.itacademy.solid.l.Characters.Character;

public interface AttackStrategy {
    void attack(Character from, Character to);
}
