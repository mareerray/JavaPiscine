public class Monster extends Character {
    // constructor
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon); // calls Character with two parameters (name and maxHealth)
    }

    // attack method implementation
    @Override
    public void attack(Character opponent) throws DeadCharacterException {
        if (this.getCurrentHealth() <= 0) {
            throw new DeadCharacterException(this);
        }
        int dmg;
        if (getWeapon() != null) {
            dmg = getWeapon().getDamage();
        } else {
            dmg = 7; // Monster's default damage is 7
        }
        opponent.takeDamage(dmg);
    }

    // takeDamage method implementation
    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() <= 0){
            throw new DeadCharacterException(this);
        }
        int realDamage = (int)Math.floor(damage * 80/100);
        setCurrentHealth(getCurrentHealth() - realDamage);
    }

    // Overriding toString
    @Override
    public String toString() {
        String weaponInfo;
        if (getWeapon() != null) {
            weaponInfo = "He has the weapon " + getWeapon().toString() + ".";
        } else {
            weaponInfo = "";
        }
        if (getCurrentHealth() == 0) {
            return String.format("%s is a monster and is dead. ", getName()) + weaponInfo;
        } else {
            return String.format("%s is a monster with %d HP. ", getName(), getCurrentHealth()) + weaponInfo;
        }
    }
}

