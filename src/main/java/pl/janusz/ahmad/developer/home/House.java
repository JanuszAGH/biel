package pl.janusz.ahmad.developer.home;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class House extends Home {

    @Override
    protected void roof() {

        System.out.println("Roof with tiles");
    }

    @Override
    protected void walls() {

        System.out.println("Wals built of bricks");
    }

    @Override
    protected void foundations() {

        System.out.println("Concret and deep hole");
    }
}
