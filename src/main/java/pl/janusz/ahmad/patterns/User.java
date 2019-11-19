package pl.janusz.ahmad.patterns;

/**
 * Created by Janusz Kacki on 18/11/2019. Project; bielmarcus
 */
public class User {

    private final String userName;
    private final String emailAddress;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    private User(Builder builder) {

        this.userName = builder.userName;
        this.emailAddress = builder.emailAddress;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    public String getUserName() {

        return userName;
    }

    public String getEmailAddress() {

        return emailAddress;
    }

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public String getAddress() {

        return address;
    }

    public static class Builder {

        private String userName;
        private String emailAddress;
        private String firstName;
        private String lastName;
        private String phoneNumber;
        private String address;

        public Builder userName(String userName) {

            this.userName = userName;
            return this;
        }

        public Builder emailAddress(String emailAddress) {

            this.emailAddress = emailAddress;
            return this;
        }

        public Builder firstName(String firstName) {

            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {

            this.lastName = lastName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {

            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(String address) {

            this.address = address;
            return this;
        }

        public User build() {

            return new User(this);
        }
    }
}
