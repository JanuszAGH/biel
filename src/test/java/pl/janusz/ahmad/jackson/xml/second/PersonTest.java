package pl.janusz.ahmad.jackson.xml.second;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Janusz Kacki on 15/11/2019. Project; bielmarcus
 */
public class PersonTest {

    private XmlMapper xmlMapper;

    @Before
    public void setUp() throws Exception {

        xmlMapper = new XmlMapper();
    }

    @Test
    public void fromXML() throws IOException {

        //language=XML
        final String s = "<Person>\n" +
                "    <firstName>Rohan</firstName>\n" +
                "    <lastName>Daye</lastName>\n" +
                "    <phoneNumbers>\n" +
                "        <phoneNumbers>9911034731</phoneNumbers>\n" +
                "        <phoneNumbers>9911033478</phoneNumbers>\n" +
                "    </phoneNumbers>\n" +
                "    <address>\n" +
                "        <streetName>Name1</streetName>\n" +
                "        <city>City1</city>\n" +
                "    </address>\n" +
                "    <address>\n" +
                "        <streetName>Name2</streetName>\n" +
                "        <city>City2</city>\n" +
                "    </address>\n" +
                "</Person>";

        final Person person = xmlMapper.readValue(s, Person.class);

        System.out.println(person);
    }
}