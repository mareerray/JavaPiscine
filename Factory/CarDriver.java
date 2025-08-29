// Role : Concrete driver that create corresponding transport
public class CarDriver extends Driver {
    public Transport createTransport() {
        return TransportFactory.getTransport("Car");
    }
}