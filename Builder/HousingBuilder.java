public interface HousingBuilder {
    HousingBuilder setSize(int size);
    HousingBuilder setPrice(int price);
    HousingBuilder setRooms(int rooms);
    HousingBuilder setName(String name);
    Housing build();
}

// The builder setters return the builder itself
// so that you can create objects in a simple, readable chain of calls.
// ex. obj.setSize(10).setRooms(2);