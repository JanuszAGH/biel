package pl.janusz.gassner.main;

import pl.janusz.gassner.domain.City;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class MainStAXWriterCities {

    public static void main(String[] args) throws IOException, XMLStreamException {

        final City warsaw = new City(1, "Warsaw");
        final City cracow = new City(2, "Cracow");

        List<City> cityList = Arrays.asList(warsaw, cracow);

        CityStAXWriter.writeToXMLFile(cityList, "cities.xml");
    }
}
