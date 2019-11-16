package pl.janusz.ahmad.jackson.xml.second;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class Address {

    String streetName;
    String city;

    public Address() {

    }

    @Override
    public String toString() {

        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getStreetName() {

        return streetName;
    }

    public void setStreetName(String streetName) {

        this.streetName = streetName;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }
}
