package pl.janusz.ahmad.jackson.other;

import java.util.Date;
import java.util.List;

/**
 * Created by Janusz Kacki on 15/11/2019. Project; bielmarcus
 */
public class User {

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private List<String> emailAddresses;

    public User() {

    }

    public User(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public Date getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {

        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getEmailAddresses() {

        return emailAddresses;
    }

    public void setEmailAddresses(List<String> emailAddresses) {

        this.emailAddresses = emailAddresses;
    }

    @Override
    public String   toString() {

        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", emailAddresses=" + emailAddresses +
                '}';
    }
}
