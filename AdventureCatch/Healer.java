public interface Healer {
    void heal(Character a) throws DeadCharacterException; // heal(Character a) with no return value

    int getHealCapacity(); // getHealCapacity() returning int.
}