package pl.janusz.ahmad.patterns.factory;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public enum VehicleType {
    CAR {
        @Override
        Vehicle getVehicle() {

            return new Car();
        }
    }, TRUCK {
        @Override
        Vehicle getVehicle() {

            return new Truck();
        }
    }, ELECTRICCAR {
        @Override
        Vehicle getVehicle() {

            return new ElectricCar();
        }
    };

    abstract Vehicle getVehicle();
}
