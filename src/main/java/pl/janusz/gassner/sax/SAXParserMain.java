package pl.janusz.gassner.sax;

import org.xml.sax.SAXException;
import pl.janusz.gassner.domain.Customer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Janusz Kacki on 16/11/2019. Project; bielmarcus
 */
public class SAXParserMain {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        final List<Customer> customers = new CustomerSAXParser().parseXMLFile("customers.xml");
        customers.forEach(System.out::println);
    }
}
