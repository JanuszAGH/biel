package pl.janusz.ahmad.patterns;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class UserTest {

    @Test
    public void threeArgumentsUser() {

        final User user =
                new User.Builder()
                        .userName("JanuszAGH")
                        .emailAddress("janusz.agh@gmail.com")
                        .firstName("Janusz")
                        .address("Warszawa")
                        .build();

        assertThat(user, hasProperty("userName", equalTo("JanuszAGH")));
        assertThat(user, hasProperty("emailAddress", equalTo("janusz.agh@gmail.com")));
        assertThat(user, hasProperty("firstName", equalTo("Janusz")));
        assertThat(user, hasProperty("address", equalTo("Warszawa")));
    }
}