package pl.janusz.ahmad.developer.home;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class SummerHome extends Home {

    @Override
    protected void roof() {

        System.out.println("Light tiles");
    }

    @Override
    protected void walls() {

        System.out.println("Wooden walls");
    }

    @Override
    protected void foundations() {

        System.out.println("No deep foundations");
    }
}
