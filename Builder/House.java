public class House implements Housing {
    // variable fields to hold properties for a house
    private int size;
    private int price;
    private int rooms;
    private String name;

    // empty constructor
    // no code inside the { } and does not need any parameters (no arguments).
    // we need this simple form so that builders
    // (e.g., HouseBuilder) can build the object step by step.
    public House() {}

    // setters methods
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
        return "House{size=" + size + ", price=" + price+ ", rooms=" + rooms + ", name='" + name + "'}";
    }
}
/*
Summary Table
Part	                      Purpose
private int size;
private int price;
private int rooms;
private String name;	      Store the details (properties) of the house
public House() { }	          Empty constructor, creates a new blank House object
Setter methods:
setSize(int size),
setPrice(int price),
setRooms(int rooms),
setName(String name)	      Allow other classes to set or update each property
toString()	                  Returns a readable string with all property values in one line
 */