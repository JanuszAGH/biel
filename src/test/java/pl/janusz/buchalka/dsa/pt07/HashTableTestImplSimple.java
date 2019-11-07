package pl.janusz.buchalka.dsa.pt07;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public class HashTableTestImplSimple extends HashTableTest {

    @Override
    protected HashTable<String, Employee> getHashTable() {

        return new SimpleHashTable<>();
    }

    @Test
    public void twoSameLengthEmployeesCauseException() {

        hashTable.put(pixie.getFirstName(), pixie);

        try {
            hashTable.put(dixie.getFirstName(), dixie);
            fail();
        } catch (Exception e) {
            assertThat(e, instanceOf(ArrayIndexOutOfBoundsException.class));
        }
    }
}
