// Role : Concrete driver that create corresponding transport
public class PlaneDriver extends Driver {
    public Transport createTransport() {
        return TransportFactory.getTransport("Plane");
    }
}