package pl.janusz.gassner.main;

import org.xml.sax.Attributes;
import org.xml.sax.HandlerBase;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import pl.janusz.gassner.domain.Employee;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 17/11/2019. Project; bielmarcus
 */
public class EmployeeSAXParser {

    private static List<Employee> employeeList;

    public static List<Employee> parse(String fileName)
            throws ParserConfigurationException, SAXException, IOException {

        final Path dir = Paths.get("src", "main", "resources", "files");
        final Path xmlFile = dir.resolve(fileName);

        final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        final SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse(xmlFile.toFile(), new EmployeeHandler());

        return employeeList;
    }

    private static class EmployeeHandler extends DefaultHandler {

        private String text;
        private Employee employee;

        @Override
        public void startDocument() throws SAXException {

            employeeList = new ArrayList<>();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            if ("employee".equalsIgnoreCase(qName)) {
                employee = new Employee();
                final String idStr = attributes.getValue("id");
                final int id = Integer.parseInt(idStr);
                employee.setId(id);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            switch (qName.toLowerCase()) {
                case "age":
                    final int age = Integer.parseInt(text);
                    employee.setAge(age);
                    break;
                case "name":
                    employee.setName(text);
                    break;
                case "gender":
                    employee.setGender(text);
                    break;
                case "role":
                    employee.setRole(text);
                    break;
                case "employee":
                    employeeList.add(employee);
                    break;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            text = new String(ch, start, length);
        }
    }
}
