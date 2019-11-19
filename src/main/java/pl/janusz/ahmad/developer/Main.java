package pl.janusz.ahmad.developer;

import pl.janusz.ahmad.developer.factory.HomeFactory;
import pl.janusz.ahmad.developer.home.Home;
import pl.janusz.ahmad.developer.home.SummerHome;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class Main {

    public static void main(String[] args) {

        final HomeFactory homeFactory = new HomeFactory();
        final Home home = new SummerHome();
        homeFactory.build(home);
    }
}
