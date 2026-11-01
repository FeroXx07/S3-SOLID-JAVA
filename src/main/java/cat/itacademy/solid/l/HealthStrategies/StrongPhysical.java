package cat.itacademy.solid.l.HealthStrategies;

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
