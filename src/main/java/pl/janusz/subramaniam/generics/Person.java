package pl.janusz.subramaniam.generics;

import lombok.*;

/**
 * Created by Janusz Kacki on 01/12/2019. Project; bielmarcus
 */
//@Getter
//@Setter
@Builder
//@EqualsAndHashCode
//@ToString
@Data
public class Person {

    private final String firstName;
    private final String surname;
    private int age;
}
