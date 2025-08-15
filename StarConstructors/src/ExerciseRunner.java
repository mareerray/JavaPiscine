public class ExerciseRunner {

    public static void main(String[] args) {
        CelestialObject1 defaultStar = new CelestialObject1();
        System.out.println(defaultStar.x);
        System.out.println(defaultStar.y);
        System.out.println(defaultStar.z);
        System.out.println(defaultStar.name);

        CelestialObject1 earth = new CelestialObject1("Terre", 0.43, 0.98, 1.43);
        System.out.println(earth.x);
        System.out.println(earth.y);
        System.out.println(earth.z);
        System.out.println(earth.name);
    }
}