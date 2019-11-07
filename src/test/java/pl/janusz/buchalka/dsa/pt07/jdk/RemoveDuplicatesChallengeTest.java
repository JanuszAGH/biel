package pl.janusz.buchalka.dsa.pt07.jdk;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;
import pl.janusz.buchalka.dsa.pt07.Employee;
import pl.janusz.buchalka.dsa.pt07.HashTable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class RemoveDuplicatesChallengeTest {

    protected Employee jinks;
    protected Employee pixie;
    protected Employee dixie;
    protected Employee felix;
    protected Employee pluto;
    protected Employee tom;
    protected Employee jerry;
    protected Employee dino;

    protected List<Employee> list;

    @Before
    public void setUp() throws Exception {

        list = new ArrayList<>();

        jinks = new Employee("Jinks", "Tomcat", 1);
        pixie = new Employee("Pixie", "Mouse", 2);
        dixie = new Employee("Dixie", "Mouse", 3);
        felix = new Employee("Felix", "Cat", 4);
        pluto = new Employee("Pluto", "Dog", 7);
        tom = new Employee("Tom", "Cat", 7);
        jerry = new Employee("Jerry", "Mouse", 7);
        dino = new Employee("Dino", "Dinosaur", 3);
    }

    @Test
    public void cleanNonDuplicatesOneElementList() {

        list.add(pixie);
        RemoveDuplicatesChallenge.removeDuplicates(list);
        assertThat(list, contains(pixie));
    }

    @Test
    public void cleanNonDuplicatesTwoElementsList() {

        list.add(pixie);
        list.add(dixie);
        RemoveDuplicatesChallenge.removeDuplicates(list);
        assertThat(list, contains(pixie, dixie));
    }

    @Test
    public void cleanDuplicatedOneElementList() {

        list.add(pixie);
        list.add(pixie);
        RemoveDuplicatesChallenge.removeDuplicates(list);
        assertThat(list, contains(pixie));
    }

    @Test
    public void cleanDuplicatesTwoElementsList() {

        list.add(pixie);
        list.add(dixie);
        list.add(pixie);
        list.add(dixie);
        RemoveDuplicatesChallenge.removeDuplicates(list);
        assertThat(list, contains(pixie, dixie));
    }

    @Test
    public void cleanTripleDuplicatedList() {

        for (int i = 0; i < 3; i++) {
            list.add(pixie);
            list.add(dixie);
            list.add(jinks);
            list.add(tom);
            list.add(jerry);
            list.add(dino);
            list.add(felix);
            list.add(pluto);
        }

        RemoveDuplicatesChallenge.removeDuplicates(list);
        assertThat(list,hasSize(8));
    }
}
