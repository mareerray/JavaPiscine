public class ApartmentBuilder implements HousingBuilder {
    // variable fields to hold an apartment object
    private Apartment apartment;

    // structor creates an empty House object by calling new House(),
    // and stores it in the house variable.
    public ApartmentBuilder () {
        this.apartment = new Apartment();
    }

    // setters : Each setter does two important things:
    //Sets a value in the apartment object (like its size, price, rooms, or name).
    //Returns the HouseBuilder itself so more setters can be chained one after another.
    public HousingBuilder setSize(int size) {
        apartment.setSize(size);    // call setSize on the apartment object
        return this;            // return the same builder to chain more calls
    }

    public HousingBuilder setPrice(int price) {
        apartment.setPrice(price);  // call setPrice on the apartment object
        return this;
    }

    public HousingBuilder setRooms(int rooms) {
        apartment.setRooms(rooms);  // call setRooms on the apartment object
        return this;
    }

    public HousingBuilder setName(String name) {
        apartment.setName(name);    // call setName on the apartment object
        return this;
    }

    // This method finishes the building process.
    // It gives back the fully prepared House object with all the values we set earlier.
    public Housing build() {
        return apartment;  // return the built apartment object
    }
}