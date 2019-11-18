package pl.janusz.gassner.main;

import pl.janusz.gassner.domain.City;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public abstract class CityStAXWriter {

    private CityStAXWriter() {

    }

    public static void writeToXMLFile(List<City> cityList, String fileName) throws IOException, XMLStreamException {

        final Path dir = Paths.get("src", "main", "resources", "files");
        final Path xmlFile = dir.resolve(fileName);

        final XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        final BufferedOutputStream bufferedOutputStream
                = new BufferedOutputStream(new FileOutputStream(xmlFile.toFile()));

        final XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(bufferedOutputStream);

        xmlStreamWriter.writeStartDocument();

        xmlStreamWriter.writeStartElement("cities");

        for (City city : cityList) {
            final String idStr = String.valueOf(city.getId());

            xmlStreamWriter.writeStartElement("city");
            xmlStreamWriter.writeAttribute("id", idStr);

            xmlStreamWriter.writeStartElement("name");
            xmlStreamWriter.writeCharacters(city.getName());
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeStartElement("visited");
            xmlStreamWriter.writeCharacters("true");
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.writeEndElement();
        }

        xmlStreamWriter.writeEndElement();

        xmlStreamWriter.writeEndDocument();

        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}
