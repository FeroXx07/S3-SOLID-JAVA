package cat.itacademy.solid.l;

import cat.itacademy.solid.l.Characters.Character;
import cat.itacademy.solid.l.Characters.Ghost;
import cat.itacademy.solid.l.Characters.Warrior;

public class Main {
    public static void main(String[] args) {
        Character ghost = new Ghost();
        Character warrior = new Warrior();

        ghost.attack(warrior);
        warrior.attack(ghost);
    }
}
