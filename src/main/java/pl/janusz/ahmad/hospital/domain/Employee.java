package pl.janusz.ahmad.hospital.domain;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class Employee {

    private int id;
    private String name;
    private String department;
    private boolean working;

    public Employee(int id, String name, String department, boolean working) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.working = working;
    }
}
