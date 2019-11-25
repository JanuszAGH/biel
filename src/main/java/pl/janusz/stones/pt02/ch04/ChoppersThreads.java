package pl.janusz.stones.pt02.ch04;

/**
 * Created by Janusz Kacki on 23/11/2019. Project; bielmarcus
 */
public class ChoppersThreads {

    public static void main(String[] args) {

        final int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < availableProcessors * 4; i++) {
            new Thread(new Chopper()).start();
        }
    }
}
