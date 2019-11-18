package pl.janusz.gassner.main;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pl.janusz.gassner.domain.Employee;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 17/11/2019. Project; bielmarcus
 */
public class EmployeeDOMParser {

    private static List<Employee> employeeList = new ArrayList<>();

    public static List<Employee> parse(String fileName)
            throws IOException, SAXException, ParserConfigurationException {

        final Path dir = Paths.get("src", "main", "resources", "files");
        final Path xmlFile = dir.resolve(fileName);

        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        final Document document = documentBuilder.parse(xmlFile.toFile());
        document.normalizeDocument();

        Employee employee;

        final NodeList nodeList = document.getElementsByTagName("Employee");
        for (int i = 0; i < nodeList.getLength(); i++) {
            employee = new Employee();
            final Node item = nodeList.item(i);
            Element element = (Element) item;
            final String idStr = element.getAttribute("id");
            final int id = Integer.parseInt(idStr);
            employee.setId(id);
            final String ageStr = element.getElementsByTagName("age").item(0).getTextContent().trim();
            final int age = Integer.parseInt(ageStr);
            employee.setAge(age);
            final String name = element.getElementsByTagName("name").item(0).getTextContent().trim();
            employee.setName(name);
            final String gender = element.getElementsByTagName("gender").item(0).getTextContent().trim();
            employee.setGender(gender);
            final String role = element.getElementsByTagName("role").item(0).getTextContent().trim();
            employee.setRole(role);
            employeeList.add(employee);
        }

        return employeeList;
    }
}
