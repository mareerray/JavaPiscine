import java.util.ArrayList;
import java.util.List;

/* To make make the Character as abstract.
// And change attack and takeDamage methods to abstract
// By adding 'abstract' behind public
// After this, your Character becomes like a "template".
// Subclasses must implement those two behaviors.
*/

public abstract class Character {
    private final int maxHealth; // cannot change after creation
    private int currentHealth;
    private final String name; // cannot change after creation
    private Weapon weapon;

    // declare a static list of Character
    // static means all characters share this list (not unique for each one).
    //private means only code inside the Character class can access it.
    private static List<Character> allCharacters = new ArrayList<>();

    // getters
    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    protected void setCurrentHealth(int health) {
        this.currentHealth = health;
    }

    public String getName() {
        return this.name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    // Constructor: Correctly initializes all fields, with currentHealth starting at maxHealth.
    public Character (String name, int maxHealth, Weapon weapon) {
        this.name = name;               // Set the name
        this.maxHealth = maxHealth;     // Set maxHealth
        this.currentHealth = maxHealth; // currentHealth starts at maxHealth
        this.weapon = weapon;
        allCharacters.add(this);        // Add the new character to the static list
    }

    // toString method: Shows "KO" if currentHealth is zero, uses formatted output otherwise.
    @Override
    public String toString() {
        // If currentHealth is 0, print KO
        if (this.currentHealth == 0) {
            return this.name + " : KO";
        }
        // Otherwise, print status
        return String.format("%s : %d/%d", this.name, this.currentHealth, this.maxHealth);
    }

    // takeDamage method: Reduces health, never goes below zero, does not return anything.
    public abstract void takeDamage(int damage);

    // attack method: Causes another character to lose health.
    public abstract void attack(Character opponent);

    // printStatus method : Shows all characters or "nobody" if list is empty.
    public static String printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------\n");
        if (allCharacters.isEmpty()) {
            sb.append("Nobody's fighting right now !\n");
        } else {
            sb.append("Characters currently fighting :\n");
            for (Character c : allCharacters) {
                sb.append(" - "+ c + "\n");
                // or sb.append(" - ").append(c).append("\n");
            }
        }
        sb.append("------------------------------------------\n");
        return sb.toString();
    }

    // fight method : Simulate a fight between two characters, return the winner.
    public static Character fight(Character a, Character b) {
        // Fight continues until one character reaches 0 health
        while (a.currentHealth > 0 && b.currentHealth > 0) {
            a.attack(b);
            if (b.currentHealth == 0) {
                return a;
            }
            b.attack(a);
            if (a.currentHealth == 0) {
                return b;
            }
        }
        // In case both are dead (should not happen with the given logic)
        return null;
    }
}

