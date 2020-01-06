package pl.janusz.in28minutes.concurrent;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public interface Semaphore {

    void acquire();

    void release();
}
