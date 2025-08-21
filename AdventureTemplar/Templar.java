public class Templar extends Character implements Healer, Tank {
    private final int shield;
    private final int healCapacity;

    // Constructor
    // Note: parameter needs to match the same order as required
    public Templar (String name, int maxHealth, int healCapacity, int shield){
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    // getHealCapacity method from Healer interface
    public int getHealCapacity() {
        return healCapacity;
    }

    // heal method from Healer interface
    // Note: currentHealth can't be greater the maxHealth
    public void heal(Character c) {
        if (c.getCurrentHealth() == 0) {
            return;
        }
        int healed = c.getCurrentHealth() + healCapacity;
        if (healed > c.getMaxHealth()) {
            healed = c.getMaxHealth();
        }
        c.setCurrentHealth(healed);
    }

    // getShield method from Tank interface
    public int getShield() {
        return this.shield;
    }

    // Override toString method
    @Override
    public String toString () {
        if (getCurrentHealth() == 0) {
            return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.", getName(), getShield(), getHealCapacity());
        }
        return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",getName(), getCurrentHealth(), getHealCapacity(), getShield());
    }
}