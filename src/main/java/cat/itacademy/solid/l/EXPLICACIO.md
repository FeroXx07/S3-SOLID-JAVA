# Anàlisis i Solució del Characters

El problema principal és que la classe ``Ghost`` hereta de ``Character``, però no pot rebre dany físic. Per tant, quan s'executa ``takeDamage()``, llança una excepció.

Això provoca que un ``Ghost`` no pugui substituir correctament un ``Character``, ja que modifica el comportament esperat de la classe super.

N'hi ha moltes maneres de solucionar, de fet amb només interfícies es podria, però també es pot amb una combinació herència, polimorfisme i composició. 


S'hi utilitza la composició per incorporar els atributs d'estratègies de attack i defensa:
````java
    public interface AttackStrategy {
        void attack(Character from, Character to);
    }
    public interface HealthStrategy {
        void takeDamage(int points);
    }
````
S'hi utilitza l'herència per definir la classe base per als personatges: ``Characters``
````java
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

`````
De manera que es poden definir tantes subclasses ``Character`` sense trencar el Principi de Substitució de Liskov (LSP).
````java
    public class Ghost extends Character {
        public Ghost() {
            super("Ghost", new PhysicalImmortality(), new SpookySpell());
        }
    }
    
    public class Warrior extends Character {
    
        public Warrior() {
            super("Warrior", new StrongPhysical(2), new SwordStrike());
        }
    }
````

# Exemple de estratègies

````java
public class PhysicalImmortality implements HealthStrategy {
    
    @Override
    public void takeDamage(int points) {
        System.out.println("Is Physical immortality! Cannot take physical damage!");
    }
}

public class StrongPhysical implements HealthStrategy {
    private final int physicalMitigationRate;
    
    public StrongPhysical(int physicalMitigationRate) {
        this.physicalMitigationRate = physicalMitigationRate;
    }
    
    @Override
    public void takeDamage(int points) {
        System.out.println("Resists and only takes " + (points / physicalMitigationRate) + " points of damage.");
    }
}

public class SwordStrike implements AttackStrategy {
    
    @Override
    public void attack(Character from, Character to) {
        System.out.println("The " + from.getName() + " strikes with a sword to " + to.getName());
        to.takeDamage(10);
    }
}

public class SpookySpell implements AttackStrategy {
    
    @Override
    public void attack(Character from, Character to) {
        System.out.println("The " + from.getName() + " casts a spooky spell to " + to.getName());
        to.takeDamage(10);
    }
}
````