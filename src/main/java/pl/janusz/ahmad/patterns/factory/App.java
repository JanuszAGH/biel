package pl.janusz.ahmad.patterns.factory;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class App {

    public static void main(String[] args) {

        final VehicleFactory vehicleFactory = new VehicleFactory();
        final Vehicle vehicle = vehicleFactory.getVehicle(VehicleType.ELECTRICCAR);
        vehicle.startEngine();
    }
}
