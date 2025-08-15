public class CelestialObject1 {
    double x;
    double y;
    double z;
    String name;

    // Constructor 1: Default constructor
    // takes no parameters: CelestialObject()
    // sets default values
    // Used when you write: new CelestialObject()
    public CelestialObject1() {
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        this.name = "Soleil";
    }

    // Constructor 2: Constructor with parameters
    // takes 4 parameters: CelestialObject(String name, double x, double y, double z)
    // sets the values you provide
    // used when you write: new CelestialObject("Terre", 0.43, 0.98, 1.43)
    public CelestialObject1 (String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
}