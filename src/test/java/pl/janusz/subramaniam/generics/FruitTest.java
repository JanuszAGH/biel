package pl.janusz.subramaniam.generics;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.management.ObjectName;
import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 29/11/2019. Project; bielmarcus
 */
public class FruitTest {

    private Banana banana;
    private Orange orange;
    private List<Fruit> fruits;
    private Fruit fruit;

    private String useFruitBasket(List<? extends Fruit> fruitList) {

        return "Received " + fruitList.get(0).getClass().getSimpleName();
    }

    private <T extends Fruit> String useFruitBasketTwo(List<T> fruitList) {

        return "Received " + fruitList.get(0).getClass().getSimpleName();
    }

    private String useFruitBasketThree(List<Fruit> fruitList) {

        fruitList.add(orange);

        return "Received " + fruitList.get(0).getClass().getSimpleName();
    }

    private String useFruits(Fruit fruit) {

        return "Received " + fruit.getClass().getSimpleName();
    }

    private <T> void copyBaskets(Collection<? extends T> src, Collection<? super T> dst) {

        dst.addAll(src);
    }

    @Before
    public void setUp() throws Exception {

        banana = new Banana();
        orange = new Orange();
        fruits = new ArrayList<>(Arrays.asList(banana, orange, fruit));
    }

    @Test
    public void fruits() {

        Fruit fruit = fruits.get(0);
        assertThat(fruit, instanceOf(Banana.class));
        fruits.add(banana);
        fruits.add(new Orange());
        fruits.add(new Fruit());

        List<Comparable<?>> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2.0);
        numbers.add(3L);
        numbers.add(4F);
        numbers.add(0xFF);
        numbers.add("Alice");
        numbers.add(new Date());
    }

    @Test
    public void fruitBasket() {

        String s = useFruitBasket(fruits);
        assertThat(s, is("Received Banana"));
    }

    @Test
    public void fruitsBasketWithSubcassses() {

        List<Banana> bananas = Arrays.asList(banana);
        String s = useFruitBasket(bananas);
        assertThat(s, is("Received Banana"));
    }

    @Test
    public void fruitsBasketWithSubcasssesTwo() {

        List<Banana> bananas = Arrays.asList(banana);
        String s = useFruitBasketTwo(bananas);
        assertThat(s, is("Received Banana"));
    }

    @Test
    public void fruitsBasketWithSubcasssesThree() {

        String s = useFruitBasketTwo(fruits);
        assertThat(s, is("Received Banana"));
    }

    @Test
    public void fruit() {

        String s1 = useFruits(banana);
        assertThat(s1, is("Received Banana"));

        String s2 = useFruits(orange);
        assertThat(s2, is("Received Orange"));

        String s3 = useFruits(new Fruit());
        assertThat(s3, is("Received Fruit"));
    }

    @Test
    public void copyBasketsFruits() {

        List<Fruit> destination = new ArrayList<>();
        copyBaskets(fruits, destination);
        assertThat(destination, contains(banana, orange, fruit));
    }

    @Test
    public void copyBasketsBananasToFruits() {

        List<Banana> bananas = Arrays.asList(banana, banana);
        List<Fruit> destination = new ArrayList<>();
        copyBaskets(bananas, destination);
        assertThat(destination, contains(banana, banana));
    }
}