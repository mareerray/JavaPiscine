// The import statement tells your program to use these classes from the java.util package
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


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

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> result = new HashMap<>();
        result.put("Star", 0);
        result.put("Planet", 0);
        result.put("Other", 0);

        for (CelestialObject obj : celestialObjects) {
            if (obj instanceof Star) {
                result.put("Star", result.get("Star") + obj.getMass());
            } else if (obj instanceof Planet) {
                result.put("Planet", result.get("Planet") + obj.getMass());
            } else {
                result.put("Other", result.get("Other") + obj.getMass());
            }
        }
        return result;
    }
}

/*
1. add mass property to base class (CelestialObject).
2. add getter and setter for mass (CelestialObject).
3. update every constructor in CelestialObject (and subclasses!) to accept int mass and set it.
public CelestialObject(String name, double x, double y, double z, int mass) {
    // set fields
    this.mass = mass;
}

public Star(String name, double x, double y, double z, double magnitude, int mass) {
    super(name, x, y, z, mass);
    this.magnitude = magnitude;
}

public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
    super(name, x, y, z, mass);
    this.centerStar = centerStar;
}
4. in Galaxy, add computeMassRepartition()
This method returns a Map<String, Integer> containing type names as keys
("Star", "Planet", "Other"), and the mass sum as values.
Use instanceof to check an object’s type
5. How does this work?
 - Add all kinds of space objects with different masses.
 - The computeMassRepartition() method checks if each object is a Star, Planet, or Other (using instanceof), and adds up their masses in the correct bucket/key.
 - At the end you get something like:
    {Star=6159592, Planet=65703, Other=4144}
 */
