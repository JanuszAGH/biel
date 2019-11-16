package pl.janusz.ahmad.hospital.clients;

import pl.janusz.ahmad.hospital.domain.Employee;
import pl.janusz.ahmad.hospital.domain.dao.EmployeeDAO;
import pl.janusz.ahmad.hospital.domain.dao.EmployeeDAOImpl;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class ClientModule {

    public static void hireNewEmployee(Employee employee) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.saveEmployee(employee);
    }

    public static void terminateEmployee(Employee employee) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.deleteEmployee(employee);
    }

    public static void printEmployeeReport(Employee employee) {

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
    }
}
