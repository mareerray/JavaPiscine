public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    // Constructor
    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
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
        this.heal(this);
        int dmg;
        if (getWeapon() != null) {
            dmg = getWeapon().getDamage();
        } else {
            dmg = 10; // Sorcerer's default damage is 10
        }
        opponent.takeDamage(dmg);
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
        String weaponInfo;
        if (getWeapon() != null) {
            weaponInfo = "He has the weapon " + getWeapon().toString() + ".";
        } else {
            weaponInfo = "";
        }
        if (getCurrentHealth() == 0) {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), getHealCapacity()) + weaponInfo;
        }
        return String.format("%s is a sorcerer with %d HP. It can heal %d HP.",getName(), getCurrentHealth(), getHealCapacity()) + weaponInfo;
    }
}