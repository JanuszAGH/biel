package pl.janusz.ahmad.jackson.xml.second;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class SimpleBeanTest {

    private XmlMapper xmlMapper;

    @Before
    public void setUp() throws Exception {

        xmlMapper = new XmlMapper();
    }

    @Test
    public void fromXML() throws Exception {

        //language=XML
        final String s = "<SimpleBean>\n" +
                "    <x>1</x>\n" +
                "    <y>2</y>\n" +
                "</SimpleBean>";

        final SimpleBean simpleBean = xmlMapper.readValue(s, SimpleBean.class);

        assertThat(simpleBean, hasProperty("x", is(1)));
        assertThat(simpleBean, hasProperty("y", is(2)));
    }
}