public class BaseRaclette implements Raclette {
// BaseRaclette gives the basic raclette: patates and cheese, nothing added

    // Empty constructor, not needed to do anything, but required by pattern
    public BaseRaclette() {}

    // Returns the fixed calorie value for a basic raclette
    @Override
    public int getCalories() {
        return 1000;
    }

    // Returns the fixed base ingredients for a raclette
    @Override
    public String getIngredients() {
        return "Patate, fromage à raclette";
    }

    // Converts this raclette to a readable string, e.g.
    // "Patate, fromage à raclette pour 1000 calories"
    // Overriding toString method
    @Override
    public String toString() {
        return String.format("%s pour %d calories", getIngredients(), getCalories());
    }
}