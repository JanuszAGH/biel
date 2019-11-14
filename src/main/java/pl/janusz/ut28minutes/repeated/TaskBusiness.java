package pl.janusz.ut28minutes.repeated;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class TaskBusiness {

    private TaskService taskService;

    public TaskBusiness(TaskService taskService) {

        this.taskService = taskService;
    }

    public List<String> getTasksForUser(String name) {

        List<String> selectedTasks = new ArrayList<>();
        final List<String> retrievedTodos = taskService.retrieveTodos(name);

        switch (name) {
            case "Tom":
                for (String task : retrievedTodos) {
                    if (task.trim().toLowerCase().contains("spring")) {
                        selectedTasks.add(task);
                    }
                }
                break;
            case "Ann":
            default:
                for (String task : retrievedTodos) {
                    if (!task.toLowerCase().trim().contains("Spring")) {
                        selectedTasks.add(task);
                    }
                }
                break;
        }

        return selectedTasks;
    }

    public void deleteTasks(String taskKeyword, String userName) {

        final List<String> retrieveTodos = taskService.retrieveTodos(userName);
        for (String todo : retrieveTodos) {
            if (todo.toLowerCase().trim().contains(taskKeyword.toLowerCase().trim())) {
                taskService.delete(todo);
            }
        }
    }
}
