package pl.janusz.gassner.geeks;

import pl.janusz.ba.ch03.ArrayList;
import pl.janusz.ba.ch03.List;
import pl.janusz.gassner.domain.Website;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class MainWebsiteStAXParser {

    private static List<Website> websiteList = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        Website website = null;

        final Path dir = Paths.get("src", "main", "resources", "files");
        final Path xmlFile = dir.resolve("websites.xml");

        final FileInputStream inputStream = new FileInputStream(xmlFile.toFile());

        final XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        final XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(inputStream);

        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();

            if (xmlEvent.isStartElement()) {
                final StartElement startElement = xmlEvent.asStartElement();
                final String localPart = startElement.getName().getLocalPart().toLowerCase();

                switch (localPart) {
                    case "websites":
                        websiteList = new ArrayList<>();
                        break;
                    case "website":
                        website = new Website();
                        final Attribute url = startElement.getAttributeByName(new QName("url"));
                        website.setUrl(url.getValue());
                        break;
                    case "name":
                        website.setName(getTextValue(xmlEventReader));
                        break;
                    case "category":
                        website.setCategory(getTextValue(xmlEventReader));
                        break;
                    case "status":
                        website.setStatus(getTextValue(xmlEventReader));
                        break;
                }
            }

            if (xmlEvent.isEndElement()) {
                final EndElement endElement = xmlEvent.asEndElement();
                final String localPart = endElement.getName().getLocalPart().toLowerCase();

                switch (localPart) {
                    case "website":
                        websiteList.add(website);
                        break;
                }
            }
        }

        for (int i = 0; i < websiteList.size(); i++) {
            System.out.println(websiteList.get(i));
        }
    }

    private static String getTextValue(XMLEventReader xmlEventReader) throws XMLStreamException {

        XMLEvent xmlEvent = xmlEventReader.nextEvent();
        String data = null;
        if (xmlEvent.isCharacters()) {
            final Characters characters = xmlEvent.asCharacters();
            data = characters.getData();
        }

        return data;
    }
}
