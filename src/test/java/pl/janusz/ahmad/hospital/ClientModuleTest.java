package pl.janusz.ahmad.hospital;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.janusz.ahmad.hospital.clients.ClientModule;
import pl.janusz.ahmad.hospital.domain.Employee;
import pl.janusz.ahmad.hospital.domain.dao.EmployeeDAO;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class ClientModuleTest {

    private EmployeeDAO employeeDAOMock;
    private Employee employee;
    private Employee peggy;

    @Before
    public void setUp() throws Exception {

        employeeDAOMock = Mockito
                .mock(EmployeeDAO.class);

        employee = Mockito
                .mock(Employee.class);

        peggy = new Employee(1, "Peggy", "Accounting", true);
    }

    @Test
    public void saveEmployeeToDB() {

        ClientModule.hireNewEmployee(peggy);

//        Mockito
//                .verify(employeeDAOMock)
//                .saveEmployee(employee);
    }
}