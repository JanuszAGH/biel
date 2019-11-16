package pl.janusz.ahmad.jackson.xml.first;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class PhoneObjXML {

    public static String toXML(PhoneDetails phoneDetails) throws JsonProcessingException {

        final XmlMapper xmlMapper = new XmlMapper();

        final String onePlus = xmlMapper.writeValueAsString(phoneDetails);

        return onePlus;
    }

    public static PhoneDetails fromXML(String xml) throws IOException {

        final XmlMapper xmlMapper = new XmlMapper();

        final PhoneDetails details = xmlMapper.readValue(xml, PhoneDetails.class);

        return details;
    }

    public static void main(String[] args) throws IOException {

        final String onePlus = toXML(new PhoneDetails("OnePlus", "6.4", "6/64 GB"));
        System.out.println(onePlus);

        System.out.println();

        final String xml = "<PhoneDetails>\n" +
                "    <name>OnePlus</name>\n" +
                "    <displaySize>6.4</displaySize>\n" +
                "    <memory>6/64 GB</memory>\n" +
                "</PhoneDetails>";

        final PhoneDetails fromXML = fromXML(xml);
        System.out.println(fromXML);

    }
}
