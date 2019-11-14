package pl.janusz.ut28minutes.repeated;

import java.util.List;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public interface TaskService {

    List<String> retrieveTodos(String user);

    void delete(String todo);
}
