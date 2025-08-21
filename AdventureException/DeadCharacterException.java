public class DeadCharacterException extends Exception {
    // accept a Character parameter and stores it as final
    private final Character character;
    // constructor
    public DeadCharacterException (Character character) {
        this.character = character;
    }

    // getMessage method
    /*We use @Override because we're customizing the standard getMessage() method from Exception,
    and we want Java to enforce that we do it correctly and intentionally.
     */
    @Override
    public String getMessage() {
        String typeOfCharacter;
        // use instanceof to check the actual subclass
        if (character instanceof Sorcerer) {
            typeOfCharacter = "sorcerer";
        } else if (character instanceof Templar) {
            typeOfCharacter = "templar";
        } else if (character instanceof Monster) {
            typeOfCharacter = "monster";
        } else {
            typeOfCharacter = "character"; // fallback type
        }
        // Return formatted message
        return String.format("The %s %s is dead.", typeOfCharacter, character.getName());
    }
}

/*
We use @Override on the getMessage() method in your custom exception class because:

The Exception class (your superclass) already has a method called getMessage().

You want to provide your own version of this method—one that returns a custom message based on your specific data (the character type and name).

By marking your method with @Override, you tell Java:
“This method is meant to override (replace) the method with the same signature in the superclass.”
 */