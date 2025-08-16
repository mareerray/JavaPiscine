public class Planet extends CelestialObject {
    private Star centerStar;

    // default constructor
    public Planet() {
        super();
        this.centerStar = new Star();
    }

    // custom constructor
    public Planet(String name, double x, double y, double z, Star centerStar, int mass) {
        super(name, x, y, z, mass);
        this.centerStar = centerStar;
    }

    // getter
    public Star getCenterStar() {
        return centerStar;
    }

    // setter
    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    // equal override
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false; // this line compares inherited fields
        Planet planet = (Planet) obj;
        return (centerStar != null ? centerStar.equals(planet.centerStar) : planet.centerStar == null);
    }


    // hash override
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + (centerStar != null ? centerStar.hashCode() : 0);
    }


    // toString override
    @Override
    public String toString() {
        double distanceWithCenterStar = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format("%s circles around %s at the %.3f AU", getName(), centerStar.getName(), distanceWithCenterStar);
    }
}
