package pl.janusz.gassner.main;

import org.xml.sax.SAXException;
import pl.janusz.gassner.domain.Employee;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Created by Janusz Kacki on 17/11/2019. Project; bielmarcus
 */
public class EmployeeDOMParserMain {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        final List<Employee> list = EmployeeDOMParser.parse("employees.xml");
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }
}
