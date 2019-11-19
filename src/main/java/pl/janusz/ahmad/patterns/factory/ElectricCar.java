package pl.janusz.ahmad.patterns.factory;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class ElectricCar implements Vehicle {

    @Override
    public void startEngine() {

        System.out.println("Push Button started an electric car's engine");
    }
}
