public class Apartment implements Housing {
    // variable fields
    private int size;
    private int price;
    private int rooms;
    private String name;

    // empty constructor
    // no code inside the { } and does not need any parameters (no arguments).
    // we need this simple form so that builders
    // (e.g., HouseBuilder) can build the object step by step.
    public Apartment() {}

    // setters
    public void setSize(int size) {
        this.size = size;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
    public void setName(String name) {
        this.name = name;
    }

    // overriding toString method
    @Override
    public String toString() {
        return "Apartment{size=" + size + ", price=" + price + ", rooms=" + rooms + ", name='" + name + "'}";
    }
}