public class WithColdMeats extends RacletteDecorator {
    // No extra field: The parent already stores the decorated raclette.

    // Constructor: pass the raclette to the parent (decorator) constructor
    // Always use the child class name, and call super(raclette) to let the parent handle setup.
    public WithColdMeats (Raclette raclette){
        super(raclette);
    }

    // Methods: Use super.getCalories()/super.getIngredients()
    // to use the previous (decorated) version and add your adjustment.
    // Adds 350 calories for cold meats to the decorated raclette
    @Override
    public int getCalories() {
        return super.getCalories() + 350;
    }

    // Appends ', charcuterie' to the ingredients of the decorated raclette
    @Override
    public String getIngredients() {
        return super.getIngredients() + ", charcuterie";
    }

    // Use same output style for printing (ingredients pour calories)
    @Override
    public String toString() {
        return String.format("%s pour %d calories", getIngredients(), getCalories());
    }
}