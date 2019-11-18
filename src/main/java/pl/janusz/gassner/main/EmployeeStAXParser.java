package pl.janusz.gassner.main;

import pl.janusz.gassner.domain.Employee;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public abstract class EmployeeStAXParser {

    private static List<Employee> employeeList = null;
    private static Employee employee = null;

    private EmployeeStAXParser() {

    }

    public static List<Employee> parse(String fileName) throws XMLStreamException {

        XMLEventReader xmlEventReader = getXMLEventReaderForEmployees(fileName);

        return getEmployeesFromXML(xmlEventReader);
    }

    private static List<Employee> getEmployeesFromXML(XMLEventReader xmlEventReader) throws XMLStreamException {

        while (xmlEventReader.hasNext()) {
            final XMLEvent xmlEvent = xmlEventReader.nextEvent();

            if (xmlEvent.isStartElement()) {
                final StartElement startElement = xmlEvent.asStartElement();
                final String elementName = startElement.getName().getLocalPart().toLowerCase();

                String str = null;
                switch (elementName) {
                    case "employees":
                        employeeList = new ArrayList<>();
                        break;
                    case "employee":
                        employee = new Employee();
                        final Attribute idStr = startElement.getAttributeByName(new QName("id"));
                        final int id = Integer.parseInt(idStr.getValue());
                        employee.setId(id);
                        break;
                    case "age":
                        str = getTextValue(xmlEventReader);
                        final int age = Integer.parseInt(str);
                        employee.setAge(age);
                        break;
                    case "name":
                        str = getTextValue(xmlEventReader);
                        employee.setName(str);
                        break;
                    case "gender":
                        str = getTextValue(xmlEventReader);
                        employee.setGender(str);
                        break;
                    case "role":
                        str = getTextValue(xmlEventReader);
                        employee.setRole(str);
                        break;
                }
            }

            if (xmlEvent.isEndElement()) {
                final EndElement endElement = xmlEvent.asEndElement();
                final String elementName = endElement.getName().getLocalPart().toLowerCase();

                if ("employee".equals(elementName)) {
                    employeeList.add(employee);
                }
            }
        }

        return employeeList;
    }

    private static String getTextValue(XMLEventReader xmlEventReader) throws XMLStreamException {

        String s = null;

        final XMLEvent xmlEvent = xmlEventReader.nextEvent();
        if (xmlEvent.isCharacters()) {
            final Characters characters = xmlEvent.asCharacters();
            s = characters.getData();
        }

        return s;
    }

    private static XMLEventReader getXMLEventReaderForEmployees(String fileName) throws XMLStreamException {

        final Path dir = Paths.get("src", "main", "resources", "files");
        final Path xmlFile = dir.resolve(fileName);
        XMLEventReader xmlEventReader = null;

        BufferedInputStream inputStream = null;
        try {
            inputStream = new BufferedInputStream(new FileInputStream(xmlFile.toFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);

        return xmlEventReader;
    }
}
