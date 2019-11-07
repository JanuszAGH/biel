package pl.janusz.buchalka.dsa.pt04;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 26/10/2019. Project; bielmarcus
 */
public class EmployeeTest {

    private List<Employee> employees;
    private Employee jinks;
    private Employee pixie;
    private Employee dixie;
    private Employee felix;

    @Before
    public void setUp() throws Exception {

        employees = new LinkedList<>();
        jinks = new Employee("Jinks", "Tomcat", 1);
        pixie = new Employee("Pixie", "Mouse", 2);
        dixie = new Employee("Dixie", "Mouse", 3);
        felix = new Employee("Felix", "Cat", 4);

        employees.add(jinks);
        employees.add(pixie);
        employees.add(dixie);
    }

    @Test
    public void listOfEmployees() {

        assertThat(employees, hasItem(hasProperty("firstName", is("Jinks"))));
        assertThat(employees, hasItem(hasProperty("firstName", is("Pixie"))));
        assertThat(employees, hasItem(hasProperty("firstName", is("Dixie"))));
        assertThat(employees, hasItem(hasProperty("lastName", is("Mouse"))));
        assertThat(employees, hasSize(3));
    }

    @Test
    public void firstOnlistIsjinks() {

        final Employee employee = employees.get(0);
        assertThat(employee, hasProperty("firstName", is("Jinks")));
    }

    @Test
    public void shouldReplaceJinkswithFelix() {

        employees.set(0, felix);

        final Employee employee = employees.get(0);
        assertThat(employee, hasProperty("firstName", is("Felix")));
    }

    @Test
    public void shouldContainElements() {

        List<Integer> integers = new LinkedList<>();

        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        assertThat(integers.contains(0), is(true));
        assertThat(integers.contains(1), is(true));
        assertThat(integers.contains(2), is(true));
        assertThat(integers.contains(3), is(true));
        assertThat(integers.contains(4), is(true));
    }

    @Test
    public void gapIsRemovedAfterRemovingElement() {

        List<Integer> integers = new ArrayList<>();

        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        assertThat(integers.lastIndexOf(3), is(3));
        final Integer remove = integers.remove(2);
        assertThat(integers.lastIndexOf(3), is(2));
        assertThat(remove,is(2));

    }

    @Test
    public void convertToArray() {

        List<Integer> integers = new LinkedList<>();

        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);

        final Integer[] array = new Integer[integers.size()];
        integers.toArray(array);

        assertThat(array, arrayContaining(0, 1, 2, 3, 4));
        assertThat(array, arrayWithSize(5));
    }

    @Test
    public void insertInSpecifiedPosition() {

        List<Integer> integers = new LinkedList<>();

        integers.add(0);
        integers.add(1);
        integers.add(2);

        assertThat(integers, contains(0, 1, 2));

        integers.add(1, 7);
        assertThat(integers, contains(0, 7, 1, 2));
    }

    @Test
    public void twoPixiesShouldBeEqual() {

        Employee p1 = new Employee("Pixie", "Mouse", 1);
        Employee p2 = new Employee("Pixie", "Mouse", 1);

        assertThat(p1, is(equalTo(p2)));
        assertThat(p1, is(p2));
    }
}