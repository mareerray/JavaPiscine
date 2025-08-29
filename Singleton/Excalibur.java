public class Excalibur{
    // Private field for the name
    private String name;

    // Private static field to hold the single instance
    private static Excalibur INSTANCE;

    // Private constructor (no one can create a new Excalibur from outside)
    private Excalibur(String name) {
        this.name = name;
    }

    // Method to get the name
    public String getName() {
        return this.name;
    }

    // Static method to get the only instance of Excalibur
    // When calling getInstance method ex. Excalibur.getInstance().getName()
    // an instance of Excalibur with name "Sword" should be return
    public static Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Sword");
        }
        // The first call checks if (instance == null), and creates/stores a new object.
        // Every later call just returns the exact same object.
        return INSTANCE;
    }
}
