package pl.janusz.techprimers.pt01;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class Child extends Parent {

    int x = 101;

    public static void main(String[] args) {

        Child child = new Child();
        System.out.println("Child : " + child.getChildValue());
        System.out.println("Parent : " + child.getParentValue());

        new Child().foo();
    }

    @Override
    void hello() {

        System.out.println("Child here");
    }

    private void foo() {

        hello();
        super.hello();
    }

    int getParentValue() {

        return super.x;
    }

    int getChildValue() {

        return x;
    }
}
