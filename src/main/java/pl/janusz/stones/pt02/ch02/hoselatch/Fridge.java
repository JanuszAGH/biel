package pl.janusz.stones.pt02.ch02.hoselatch;

/**
 * Created by Janusz Kacki on 21/11/2019. Project; bielmarcus
 */
public class Fridge {

    private int beer = 4;

    public synchronized void doubleBeer() {

        this.beer *= 2;
    }

    public synchronized void addTwo() {

        this.beer += 2;
    }

    public int getBeer() {

        return this.beer;
    }
}
