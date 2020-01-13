package pl.janusz.shewchuk.lec02;

/**
 * Created by Janusz Kacki on 07/01/2020. Project; bielmarcus
 */
public class SideEffect {

    public static void main(String[] args) {
        String word = null;
        System.out.println((word = "Alice"));
    }
}
