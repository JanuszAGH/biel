package pl.janusz.ahmad.patterns.factory;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class VehicleFactory {

    public Vehicle getVehicle(VehicleType vehicleType) {

        return vehicleType.getVehicle();
    }
}
