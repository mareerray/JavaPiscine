public abstract class RacletteDecorator implements Raclette {
// Abstract decorator: base class for all Raclette decorators (like pickles or meats).
// It implements Raclette, so it must override all interface methods.

    // The Raclette object being decorated (wrapped)
    protected Raclette raclette;

    // Constructor: takes a Raclette and decorates it
    public RacletteDecorator (Raclette raclette){
        this.raclette = raclette;  // Save the Raclette being decorated
    }

    // Returns calories of the wrapped Raclette (no change here, decorators can add!)
    @Override
    public int getCalories() {
        return raclette.getCalories();
    }

    // Returns ingredients of the wrapped Raclette (no change, decorators will add!)
    @Override
    public String getIngredients() {
        return raclette.getIngredients();
    }

    // Use same output style for printing (ingredients pour calories)
    @Override
    public String toString() {
        return String.format("%s pour %d calories", getIngredients(), getCalories());
    }
}