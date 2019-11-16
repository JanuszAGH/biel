package pl.janusz.ahmad.jackson.other;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.collection.IsArrayContaining;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Janusz Kacki on 15/11/2019. Project; bielmarcus
 */
public class UserTest {

    private User user1;
    private User user2;
    private ObjectMapper objectMapper;
    private String usersJson;

    @Before
    public void setUp() throws Exception {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        user1 = new User("Harrison", "Ford");
        user2 = new User("Samuel", "Jackson");
        user1.setEmailAddresses(Arrays.asList("harrison@example.com", "harrisonford@gmail.com"));
        user2.setEmailAddresses(Arrays.asList("jackson@example.com", "samueljackson@gmail.com"));

        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-d");
        objectMapper.setDateFormat(dateFormat);
        usersJson = "[\n" +
                "  {\n" +
                "    \"firstName\": \"Harrison\",\n" +
                "    \"lastName\": \"Ford\",\n" +
                "    \"dateOfBirth\": \"13-Jul-1942\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstName\": \"Samuel\",\n" +
                "    \"lastName\": \"Jackson\",\n" +
                "    \"dateOfBirth\": \"21-Dec-1948\"\n" +
                "  }\n" +
                "]";
    }

    @Test
    public void writeJson() {

        Calendar calendar = Calendar.getInstance();
        calendar.set(1942, 6, 13);
        user1.setDateOfBirth(calendar.getTime());
        calendar.clear();
        calendar.set(1948, 11, 21);
        user2.setDateOfBirth(calendar.getTime());

        final List<User> users = Arrays.asList(user1, user2);

        try {
            final String s = objectMapper.writeValueAsString(users);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readJSON() throws IOException {

        final String json = "{\n" +
                "  \"firstName\" : \"Harrison\",\n" +
                "  \"lastName\" : \"Ford\",\n" +
                "  \"dateOfBirth\" : \"1942-7-13\",\n" +
                "  \"emailAddresses\" : [ \"harrison@example.com\", \"harrisonford@gmail.com\" ]\n" +
                "\n" +
                "}";

        final User user = objectMapper.readValue(json, User.class);
        System.out.println(user);
    }

    @Test
    public void readArrayOfUsers() throws IOException {

        List<User> usersList = objectMapper.readValue(usersJson, new TypeReference<List<User>>() {

        });
//        assertThat(usersArray, arrayContaining(user1, user2));
        for (User user : usersList) {
            System.out.println(user);
        }
    }
}
