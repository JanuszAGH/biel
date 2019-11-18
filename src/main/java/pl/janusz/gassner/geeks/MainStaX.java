package pl.janusz.gassner.geeks;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class MainStaX {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        final Path dir = Paths.get("src", "main", "resources", "files");
        final Path xmlFile = dir.resolve("geeks.xml");

        final BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(xmlFile.toFile()));

        final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        final XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);

        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            if (xmlEvent.isStartElement()) {
                final StartElement startElement = xmlEvent.asStartElement();
                final String localPart = startElement.getName().getLocalPart();
                System.out.println("START " + localPart);
                xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isCharacters()) {
                    final Characters characters = xmlEvent.asCharacters();
                    final String data = characters.getData();
                    System.out.println("\t " + data);
                }
            }
            if (xmlEvent.isEndElement()) {
                final EndElement endElement = xmlEvent.asEndElement();
                final String localPart = endElement.getName().getLocalPart();
                System.out.println("END " + localPart);
            }
        }
    }
}
