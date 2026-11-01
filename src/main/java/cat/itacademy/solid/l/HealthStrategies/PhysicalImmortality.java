package cat.itacademy.solid.l.HealthStrategies;

public class PhysicalImmortality implements HealthStrategy {
    @Override
    public void takeDamage(int points) {
        System.out.println("Is Physical immortality! Cannot take physical damage!");
    }
}
