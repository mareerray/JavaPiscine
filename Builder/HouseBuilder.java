public class HouseBuilder implements HousingBuilder {
    // variable fields to hold a house object
    private House house;

    // structor creates an empty House object by calling new House(),
    // and stores it in the house variable.
    public HouseBuilder () {
        this.house = new House();
    }

    // setters : Each setter does two important things:
    //Sets a value in the house object (like its size, price, rooms, or name).
    //Returns the HouseBuilder itself so more setters can be chained one after another.
    public HousingBuilder setSize(int size) {
        house.setSize(size);    // call setSize on the house object
        return this;            // return the same builder to chain more calls
    }

    public HousingBuilder setPrice(int price) {
        house.setPrice(price);  // call setPrice on the house object
        return this;
    }

    public HousingBuilder setRooms(int rooms) {
        house.setRooms(rooms);  // call setRooms on the house object
        return this;
    }

    public HousingBuilder setName(String name) {
        house.setName(name);    // call setName on the house object
        return this;
    }

    // This method finishes the building process.
    // It gives back the fully prepared House object with all the values we set earlier.
    public Housing build() {
        return house;  // return the built house object
    }
}
/*
Summary Table
Part	                Purpose
private House house;	Stores the house under construction
Constructor	            Creates a new, empty House when builder starts
Setters	                Update values inside the House and return the builder
build()	                Returns the ready-to-use House object
 */