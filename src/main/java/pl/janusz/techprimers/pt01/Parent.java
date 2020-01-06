package pl.janusz.techprimers.pt01;

/**
 * Created by Janusz Kacki on 02/12/2019. Project; bielmarcus
 */
public class Parent {

    int x = 10;

    void hello() {

        int x = 1001;
        System.out.println("Parent here");
    }

    public boolean equals(Parent p) {

        if (this == p) return true;

        return x == p.x;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parent parent = (Parent) o;

        return x == parent.x;
    }

    @Override
    public int hashCode() {

        return x;
    }

    private class Aunt {

        int x = 333;

        void hello() {

            System.out.println("Aunt here");
        }
    }
}


