package pl.janusz.gassner.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import pl.janusz.gassner.domain.Customer;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Janusz Kacki on 16/11/2019. Project; bielmarcus
 */
public class CustomerSAXParser {

    private static final String XMLDATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    private List<Customer> customers = Collections.emptyList();

    public List<Customer> parseXMLFile(String fileName) throws ParserConfigurationException, SAXException, IOException {

        final Path dir = Paths.get("src", "main", "resources", "files", "data");
        final Path path = dir.resolve(fileName);

        final SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        final SAXParser saxParser = saxParserFactory.newSAXParser();

        saxParser.parse(path.toFile(), new CustomerSAXHandler());

        return customers;
    }

    private class CustomerSAXHandler extends DefaultHandler {

        @Override
        public void startDocument() throws SAXException {

            customers = new ArrayList<>();
            System.out.println("Start XML Document");
        }

        @Override
        public void endDocument() throws SAXException {

            System.out.println("Start XML Document");
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            System.out.println("Start Element " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {

            System.out.println("End Element " + qName);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {

            final String s = new String(ch, 0, length);
            System.out.println("Characters - TEXT ");
        }
    }
}
