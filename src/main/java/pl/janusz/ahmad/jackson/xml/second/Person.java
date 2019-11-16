package pl.janusz.ahmad.jackson.xml.second;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class Person {

    private String firstName;
    private String lastName;
    private List<String> phoneNumbers = new ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Address> address = new ArrayList<>();

    public Person() {

    }

    @Override
    public String toString() {

        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", address=" + address +
                '}';
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public List<String> getPhoneNumbers() {

        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {

        this.phoneNumbers = phoneNumbers;
    }

    public List<Address> getAddress() {

        return address;
    }

    public void setAddress(List<Address> address) {

        this.address = address;
    }
}