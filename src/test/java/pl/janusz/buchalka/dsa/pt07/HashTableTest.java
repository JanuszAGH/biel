package pl.janusz.buchalka.dsa.pt07;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public abstract class HashTableTest {

    protected HashTable<String, Employee> hashTable;
    protected Employee jinks;
    protected Employee pixie;
    protected Employee dixie;
    protected Employee felix;
    protected Employee pluto;
    protected Employee tom;
    protected Employee jerry;
    protected Employee dino;

    @Before
    public void setUp() throws Exception {

        hashTable = getHashTable();

        jinks = new Employee("Jinks", "Tomcat", 1);
        pixie = new Employee("Pixie", "Mouse", 2);
        dixie = new Employee("Dixie", "Mouse", 3);
        felix = new Employee("Felix", "Cat", 4);
        pluto = new Employee("Pluto", "Dog", 7);
        tom = new Employee("Tom", "Cat", 7);
        jerry = new Employee("Jerry", "Mouse", 7);
        dino = new Employee("Dino", "Dinosaur", 3);
    }

    protected abstract HashTable<String, Employee> getHashTable();

    @Test
    public void putGetOneElementToEmptyHashTable() {

        hashTable.put(jinks.getFirstName(), jinks);
        final Employee employee = hashTable.get(jinks.getFirstName());
        assertThat(employee, is(jinks));
        assertThat(hashTable.size(), is(1));
    }

    @Test
    public void putGetTwoElementsToEmptyHashTable() {

        hashTable.put(jinks.getFirstName(), jinks);
        hashTable.put(tom.getFirstName(), tom);
        Employee employee;
        employee = hashTable.get(jinks.getFirstName());
        assertThat(employee, is(jinks));
        employee = hashTable.get(tom.getFirstName());
        assertThat(employee, is(tom));
        assertThat(hashTable.size(), is(2));
    }

    @Test
    public void removeElementFromOneElementHashTable() {

        hashTable.put(pixie.getFirstName(), pixie);
        Employee remove = hashTable.remove(pixie.getFirstName());
        assertThat(remove, is(pixie));
        assertThat(hashTable.size(), is(0));
    }

    @Test
    public void addOneRmoveOneAddAndremoveAgain() {

        hashTable.put(pixie.getFirstName(), pixie);
        assertThat(hashTable.remove(pixie.getFirstName()), is(pixie));
        assertThat(hashTable.size(), is(0));
        hashTable.put(dixie.getFirstName(), dixie);
        assertThat(hashTable.remove(dixie.getFirstName()), is(dixie));
        assertThat(hashTable.size(), is(0));
    }

    @Test
    public void addOneRmoveOneAddAndremoveRepeatedTwoTimes() {

        hashTable.put(pixie.getFirstName(), pixie);
        hashTable.put(dino.getFirstName(), dino);
        hashTable.put(tom.getFirstName(), tom);
        assertThat(hashTable.remove(pixie.getFirstName()), is(pixie));
        hashTable.put(dixie.getFirstName(), dixie);
        assertThat(hashTable.remove(dixie.getFirstName()), is(dixie));
        assertThat(hashTable.remove(dino.getFirstName()), is(dino));
        assertThat(hashTable.remove(tom.getFirstName()), is(tom));
    }

    @Test
    public void getNonExistingValueFromEmptyHashTableReturnsNull() {

        assertThat(hashTable.get(pixie.getFirstName()), is(nullValue()));
    }

    @Test
    public void removedEntryNotLongerPresent() {

        hashTable.put(pixie.getFirstName(), pixie);
        assertThat(hashTable.size(), is(1));
        assertThat(hashTable.remove(pixie.getFirstName()), is(pixie));
        assertThat(hashTable.size(), is(0));
        assertThat(hashTable.get(pixie.getFirstName()), is(nullValue()));
        assertThat(hashTable.size(), is(0));
    }

    @Test
    public void removeNonPresentReturnsNull() {

        assertThat(hashTable.size(), is(0));
        hashTable.put(pixie.getFirstName(), pixie);
        assertThat(hashTable.size(), is(1));
        hashTable.put(tom.getFirstName(), tom);
        assertThat(hashTable.size(), is(2));
        final Employee remove = hashTable.remove(dino.getFirstName());
        assertThat(remove, is(nullValue()));
        assertThat(hashTable.size(), is(2));
    }
}