package pl.janusz.gassner.main;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Janusz Kacki on 17/11/2019. Project; bielmarcus
 */
public class CompanyDOMBuilderMain {

    private final static Path dir = Paths.get("src", "main", "resources", "files");
    private final static Path xmlFile = dir.resolve("company.xml");

    public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        final Document document = documentBuilder.newDocument();

        final Element root = document.createElement("company");
        document.appendChild(root);

        final Element staff = document.createElement("staff");
        staff.setAttribute("id", "1");
        root.appendChild(staff);

        final Element firstname = document.createElement("firstname");
        firstname.appendChild(document.createTextNode("Yong"));
        staff.appendChild(firstname);

        final Element lastname = document.createElement("lastname");
        lastname.appendChild(document.createTextNode("Mook Kim"));
        staff.appendChild(lastname);

        final Element nickname = document.createElement("nickname");
        nickname.appendChild(document.createTextNode("Mkyong"));
        staff.appendChild(nickname);

        final Element salary = document.createElement("salary");
        salary.appendChild(document.createTextNode("100000"));
        staff.appendChild(salary);

//        document.getElementsByTagName("salary").item(0).setTextContent("30000");
        final Node node = document.getElementsByTagName("salary").item(0);
        node.getParentNode().removeChild(node);

        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

        final DOMSource domSource = new DOMSource(document);
        final StreamResult streamResult = new StreamResult(xmlFile.toFile());

        transformer.transform(domSource, streamResult);
    }
}
