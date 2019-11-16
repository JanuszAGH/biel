package pl.janusz.ahmad.hospital.domain.dao;

import pl.janusz.ahmad.hospital.domain.Employee;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public interface EmployeeDAO {

    void saveEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
