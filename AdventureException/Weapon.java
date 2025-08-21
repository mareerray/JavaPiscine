public class Weapon {
    private final String name;
    private final int damage;
    // final makes the variable immutable after it's set in the constructor.
    // make the property "read-only"

    // getter
    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }
     // constructor
    public Weapon (String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    // toString method
    @Override
    public String toString() {
        return String.format("%s deals %d damages", getName(), getDamage());
    }
}