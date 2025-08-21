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
    @Override
    public void heal(Character a) throws DeadCharacterException {
        if (getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        if (a.getCurrentHealth() <= 0) {
            throw new DeadCharacterException(a);
        }
            int healed = a.getCurrentHealth() + healCapacity;
            if (healed > a.getMaxHealth()) {
                healed = a.getMaxHealth();
            }
            a.setCurrentHealth(healed);

    }

    // attack method implementation
    @Override
    public void attack(Character opponent) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
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
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() <= 0){
            throw new DeadCharacterException(this);
        }
        setCurrentHealth(getCurrentHealth() - damage);
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