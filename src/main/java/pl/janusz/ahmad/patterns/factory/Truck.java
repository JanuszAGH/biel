package pl.janusz.ahmad.patterns.factory;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class Truck implements Vehicle {

    @Override
    public void startEngine() {

        System.out.println("Started a large engine of truck");
    }
}
