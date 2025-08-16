// Inheritance in Java is done with the keyword extends
// When you create a new Star object, all values from both CelestialObject and Star
// show their default result at first, until you change them.

public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super(); // calls CelestialObject default constructor
        // because Star inherits from CelestialObject
        this.magnitude = 0.0;
    }

    public Star (String name, double x, double y, double z, double magnitude) {
        super(name, x, y, z); // calls CelestialObject constructor with arguments
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    // Override toString
    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", getName(), magnitude);
        // use getName() instead of this.name since name is set to private in the superclass
    }

    // Override equals
    @Override
    public boolean equals(Object obj) {
        // check if other object is a Star
        if (this == obj) return true;
        if (!(obj instanceof Star)) return false;

        // Check CelestialObject fields
        // call super.equals(obj) to compare the inherited fields
        if (!super.equals(obj)) return false;

        // compare only magnitude
        Star star = (Star) obj;
        return Double.compare(this.magnitude, star.magnitude) == 0;
    }

    // Override hashcode
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + Double.hashCode(magnitude);
        // this line multiplies the parent’s hash code by 31
        // (a prime number commonly used in Java for hash codes
        // to help spread out the values and reduce collisions).
        // Then it adds the hash code of magnitude.
    }
}

/*🗝️ Tips
Always use @Override to let Java check you’re correctly overriding.

Use super(...) to call a constructor from the parent class.

For equals, always check type and cast properly.

For hashCode, use the same properties as in equals.

Use String.format() for formatting doubles to a fixed number of decimals.

 */