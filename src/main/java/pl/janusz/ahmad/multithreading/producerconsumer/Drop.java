package pl.janusz.ahmad.multithreading.producerconsumer;

/**
 * Created by Janusz Kacki on 19/11/2019. Project; bielmarcus
 */
public interface Drop {

    void put(String message);

    String take();
}
