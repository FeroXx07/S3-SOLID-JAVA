package cat.itacademy.solid.l.Characters;

import cat.itacademy.solid.l.AttackStrategies.AttackStrategy;
import cat.itacademy.solid.l.HealthStrategies.HealthStrategy;

public class Character {
    private final HealthStrategy healthStrategy;
    private final AttackStrategy attackStrategy;
    private final String name;

    public Character(String name, HealthStrategy healthStrategy, AttackStrategy attackStrategy) {
        this.healthStrategy = healthStrategy;
        this.attackStrategy = attackStrategy;
        this.name = name;
    }

    public void attack(Character to) {
        attackStrategy.attack(this, to);
    }

    public void takeDamage(int points) {
        healthStrategy.takeDamage(points);
    }

    public String getName() {return name;}
}
