package pl.janusz.techprimers.pt01;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class Demo {

    public static void main(String[] args) {

        Parent parent = new Parent();
        Child child = new Child();
        ((Parent)child).hello();
    }
}
