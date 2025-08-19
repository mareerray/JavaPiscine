public class Monster extends Character {
    // constructor
    public Monster(String name, int maxHealth) {
        super(name, maxHealth); // calls Character with two parameters (name and maxHealth)
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

/*
The constructor takes String name and int maxHealth and calls super(name, maxHealth);
— exactly what Java inheritance requires!

toString() checks if the monster is dead (getCurrentHealth() == 0)
and returns the right string format depending on its state.

Use the getters (getName(), getCurrentHealth())
which is best practice when parent fields are private.
 */