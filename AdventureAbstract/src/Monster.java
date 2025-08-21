public class Monster extends Character {
    // constructor
    public Monster(String name, int maxHealth) {
        super(name, maxHealth); // calls Character with two parameters (name and maxHealth)
    }

    // attack method implementation
    @Override
    public void attack(Character opponent) {
        opponent.takeDamage(7); // Monster attacks for 7 damage
    }

    // takeDamage method implementation
    @Override
    public void takeDamage(int damage) {
        int realDamage = (int)Math.floor(damage * 80/100);
        setCurrentHealth(getCurrentHealth() - realDamage);
        if (getCurrentHealth() < 0){
            setCurrentHealth(0);
        }
    }

    // Overriding toString
    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return String.format("%s is a monster and is dead", getName());
        } else {
            return String.format("%s is a monster with %d HP", getName(), getCurrentHealth());
        }
    }
}

