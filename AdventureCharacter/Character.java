public class Character {
    private final int maxHealth; // cannot change after creation
    private int currentHealth;
    private final String name; // cannot change after creation

    // getters
    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public String getName() {
        return this.name;
    }

    // Constructor: Correctly initializes all fields, with currentHealth starting at maxHealth.
    public Character (String name, int maxHealth) {
        this.name = name;               // Set the name
        this.maxHealth = maxHealth;     // Set maxHealth
        this.currentHealth = maxHealth; // currentHealth starts at maxHealth
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
    public void takeDamage(int damage) {
        this.currentHealth = this.currentHealth - damage;
        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }
    }

    // attack method: Causes another character to lose health.
    public void attack(Character opponent) {
        opponent.takeDamage(9);
    }
}

