// The import statement tells your program to use these classes from the java.util package
import java.util.List;
import java.util.ArrayList;

// Galaxy will contain many different kinds of CelestialObject (planets, stars, etc).
public class Galaxy {
    private List<CelestialObject> celestialObjects;
    // Declare a list property
    // This list holds any kind of celestial object:
    // Star, Planet, etc, all as CelestialObject references
    // And use private for encapsulation

    // default constructor
    public Galaxy() {
        this.celestialObjects = new ArrayList<>();
        // Initialize the list after you declared it
        // Now the list is set up, empty, and ready to use.
    }

    // getter allow others to get (read) the list
    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    // add method to let users add any CelestialObject
    public void addCelestialObject(CelestialObject obj) {
        celestialObjects.add(obj);
    }
}

/*
Polymorphism means that a single variable or method can work with different types of objects, and will do the "right thing" for each type.

Imagine this:
You have a remote control (the variable) that can control a TV, a fan, or an air conditioner (different object types).
When you press the "power" button, each device will turn on in its own way.

In Java:
If you make a list of space objects (planets, stars, moons), and you ask each object to show itself:

The planet will print its info as a planet.

The star will print its info as a star.

The moon will print its info as a moon.

The same command, but each object responds in its own way.

In one sentence:
Polymorphism lets you write code that works with many kinds of objects, and each object knows how to do its job correctly.

 */