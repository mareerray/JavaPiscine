// Inheritance in Java is done with the keyword extends
// When you create a new Star object, all values from both CelestialObject and Star
// show their default result at first, until you change them.

public class Star extends CelestialObject {
    private double magnitude;

    public double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }
}