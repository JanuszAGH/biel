package pl.janusz.gassner.main;

import pl.janusz.gassner.domain.Employee;

import javax.xml.stream.XMLStreamException;
import java.util.List;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class EmployeeStAXParserMain {

    public static void main(String[] args) throws XMLStreamException {

        List<Employee> employeeList = EmployeeStAXParser.parse("employees.xml");
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
