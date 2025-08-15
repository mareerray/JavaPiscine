public class CelestialObject {
    private double x;
    private double y;
    private double z;
    private String name;

    // Constructor 1: Default constructor
    // takes no parameters: CelestialObject()
    // sets default values
    // Used when you write: new CelestialObject()
    public CelestialObject () {
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
        this.name = "Soleil";
    }

    // Constructor 2: Constructor with parameters
    // takes 4 parameters: CelestialObject(String name, double x, double y, double z)
    // sets the values you provide
    // used when you write: new CelestialObject("Terre", 0.43, 0.98, 1.43)
    public CelestialObject (String name, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    // Adding getters/setters for each variable
    public double getX() {
        return this.x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return this.y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getZ() {
        return this.z;
    }
    public void setZ(double z) {
        this.z = z;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Static copnstant (always use static final and ALL_CAPS)
    public static final double KM_IN_ONE_AU = 150_000_000;

    // Static methods for distance calculation
    public static double getDistanceBetween(CelestialObject a, CelestialObject b) {
        double dx = a.getX() - b.getX();
        double dy = a.getY() - b.getY();
        double dz = a.getZ() - b.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject a, CelestialObject b) {
        return getDistanceBetween(a, b) * KM_IN_ONE_AU;
    }
}