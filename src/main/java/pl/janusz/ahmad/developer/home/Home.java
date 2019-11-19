package pl.janusz.ahmad.developer.home;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public abstract class Home {

    public void buildHome() {

        foundations();
        walls();
        roof();
    }

    protected abstract void roof();

    protected abstract void walls();

    protected abstract void foundations();
}
