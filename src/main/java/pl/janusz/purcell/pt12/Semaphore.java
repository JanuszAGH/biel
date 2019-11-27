package pl.janusz.purcell.pt12;

/**
 * Created by Janusz Kacki on 27/11/2019. Project; bielmarcus
 */
public interface Semaphore {

    void acquire();

    void release();

    void setAvailableSlots(int slots);
}
