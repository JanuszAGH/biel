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
public abstract class AvancedHashTableTest extends HashTableTest {


    @Test
    public void putTwoElements() {

        hashTable.put(pixie.getFirstName(), pixie);
        hashTable.put(dixie.getFirstName(), dixie);

        Employee employee;
        employee = hashTable.get(pixie.getFirstName());
        assertThat(employee, is(pixie));
        employee = hashTable.get(dixie.getFirstName());
        assertThat(employee, is(dixie));
    }

    @Test
    public void putFourElements() {

        hashTable.put(pixie.getFirstName(), pixie);
        hashTable.put(dixie.getFirstName(), dixie);
        hashTable.put(felix.getFirstName(), felix);
        hashTable.put(jinks.getFirstName(), jinks);

        assertThat(hashTable.get(felix.getFirstName()), is(felix));
        assertThat(hashTable.get(pixie.getFirstName()), is(pixie));
        assertThat(hashTable.get(jinks.getFirstName()), is(jinks));
        assertThat(hashTable.get(dixie.getFirstName()), is(dixie));
    }

    @Test
    public void addFourElementsRemoveFourelementsRepeatedTwice() {

        hashTable.put(pixie.getFirstName(), pixie);
        hashTable.put(dixie.getFirstName(), dixie);
        hashTable.put(jinks.getFirstName(), jinks);
        hashTable.put(felix.getFirstName(), felix);
        assertThat(hashTable.remove(pixie.getFirstName()), is(pixie));
        assertThat(hashTable.remove(dixie.getFirstName()), is(dixie));
        assertThat(hashTable.remove(felix.getFirstName()), is(felix));
        assertThat(hashTable.remove(jinks.getFirstName()), is(jinks));

        hashTable.put(pluto.getFirstName(), pluto);
        hashTable.put(tom.getFirstName(), tom);
        hashTable.put(jerry.getFirstName(), jerry);
        hashTable.put(dino.getFirstName(), dino);
        assertThat(hashTable.remove(dino.getFirstName()), is(dino));
        assertThat(hashTable.remove(tom.getFirstName()), is(tom));
        assertThat(hashTable.remove(pluto.getFirstName()), is(pluto));
        assertThat(hashTable.remove(jerry.getFirstName()), is(jerry));
    }

    @Test
    public void putEightItems() {

        hashTable.put(pixie.getFirstName(), pixie);
        assertThat(hashTable.size(), is(1));
        hashTable.put(dixie.getFirstName(), dixie);
        assertThat(hashTable.size(), is(2));
        hashTable.put(jinks.getFirstName(), jinks);
        assertThat(hashTable.size(), is(3));
        hashTable.put(felix.getFirstName(), felix);
        assertThat(hashTable.size(), is(4));
        hashTable.put(pluto.getFirstName(), pluto);
        assertThat(hashTable.size(), is(5));
        hashTable.put(dino.getFirstName(), dino);
        assertThat(hashTable.size(), is(6));
        hashTable.put(tom.getFirstName(), tom);
        assertThat(hashTable.size(), is(7));
        hashTable.put(jerry.getFirstName(), jerry);
        assertThat(hashTable.size(), is(8));

        assertThat(hashTable.remove(pixie.getFirstName()), is(pixie));
        assertThat(hashTable.size(), is(7));
        assertThat(hashTable.remove(dixie.getFirstName()), is(dixie));
        assertThat(hashTable.size(), is(6));
        assertThat(hashTable.remove(tom.getFirstName()), is(tom));
        assertThat(hashTable.size(), is(5));
        assertThat(hashTable.remove(dino.getFirstName()), is(dino));
        assertThat(hashTable.size(), is(4));
        assertThat(hashTable.remove(jerry.getFirstName()), is(jerry));
        assertThat(hashTable.size(), is(3));
        assertThat(hashTable.remove(jinks.getFirstName()), is(jinks));
        assertThat(hashTable.size(), is(2));
        assertThat(hashTable.remove(felix.getFirstName()), is(felix));
        assertThat(hashTable.size(), is(1));
        assertThat(hashTable.remove(pluto.getFirstName()), is(pluto));
        assertThat(hashTable.size(), is(0));

    }
}
