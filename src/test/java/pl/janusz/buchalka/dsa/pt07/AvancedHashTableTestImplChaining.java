package pl.janusz.buchalka.dsa.pt07;

/**
 * Created by Janusz Kacki on 04/11/2019. Project; bielmarcus
 */
public class AvancedHashTableTestImplChaining extends AvancedHashTableTest {

    @Override
    protected HashTable<String, Employee> getHashTable() {

        return new HashTableChaining<>();
    }
}
