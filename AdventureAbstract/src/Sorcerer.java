public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    // Constructor
    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    // getHealCapacity method from the Healer interface
    public int getHealCapacity() {
        return healCapacity;
    }

    // heal method from the Healer interface
    public void heal(Character a) {
        if (a.getCurrentHealth() == 0) {
            return;
        }
        int healed = a.getCurrentHealth() + healCapacity;
        if (healed > a.getMaxHealth()) {
            healed = a.getMaxHealth();
        }
        a.setCurrentHealth(healed);
    }

    // attack method implementation
    @Override
    public void attack(Character opponent) {
        this.heal(this); // Sorcerer heals itself first
        opponent.takeDamage(10); // then attacks for 10 damage
    }

    // takeDamage method implementation
    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - damage);
        if (getCurrentHealth() < 0){
            setCurrentHealth(0);
        }
    }

    // toString method
    @Override
    public String toString () {
        if (getCurrentHealth() == 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), getHealCapacity());
        }
        return String.format("%s is a sorcerer with %d HP. It can heal %d HP.",getName(), getCurrentHealth(), getHealCapacity());
    }
}