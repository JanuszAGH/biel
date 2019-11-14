package pl.janusz.ut28minutes.repeated;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 14/11/2019. Project; bielmarcus
 */
public class TaskServiceTest {

    private TaskService mock;
    private String programmer;
    private String girl;
    private String other;
    private List<String> todos;
    private TaskBusiness sut;
    private String[] springTasks;
    private String[] otherTasks;
    private ArgumentCaptor<String> argumentCaptor;

    @Before
    public void setUp() throws Exception {

        programmer = "Tom";
        girl = "Ann";
        other = "Jack";
        todos = Arrays.asList("Learn Spring MVC", "Learn to Dance", "Learn Spring");
        springTasks = new String[]{"Learn Spring MVC", "Learn Spring"};
        otherTasks = new String[]{"Learn to Dance"};

        mock = Mockito
                .mock(TaskService.class);

        argumentCaptor = ArgumentCaptor.forClass(String.class);

        sut = new TaskBusiness(mock);
    }

    @Test
    public void getSpringTasks() {

        Mockito
                .when(mock.retrieveTodos(Mockito.anyString()))
                .thenReturn(todos);

        final List<String> tasks = sut.getTasksForUser(programmer);

        Mockito
                .verify(mock, Mockito.times(1))
                .retrieveTodos(Mockito.anyString());

        assertThat(tasks, hasSize(2));
        assertThat(tasks, containsInAnyOrder(springTasks));
    }

    @Test
    public void getBothFamilysTasks() {

        Mockito
                .when(mock.retrieveTodos(Mockito.anyString()))
                .thenAnswer(new Answer<List<String>>() {

                    @Override
                    public List<String> answer(InvocationOnMock invocationOnMock) throws Throwable {

                        final Object[] arguments = invocationOnMock.getArguments();
                        switch (arguments[0].toString().toLowerCase().trim()) {
                            case "husband":
                                return Arrays.asList(springTasks);
                            case "wife":
                                return Arrays.asList(otherTasks);
                            default:
                                return Collections.emptyList();
                        }
                    }
                });

        final List<String> husbandsTasks = sut.getTasksForUser("husband");
        final List<String> wifesTasks = sut.getTasksForUser("wife");

        assertThat(husbandsTasks, containsInAnyOrder(springTasks));
        assertThat(wifesTasks, containsInAnyOrder(otherTasks));
    }

    @Test
    public void deleteTasks() {

        Mockito
                .when(mock.retrieveTodos(Mockito.anyString()))
                .thenReturn(todos);

        sut.deleteTasks("Spring", programmer);

        Mockito
                .verify(mock,Mockito.times(2))
                .delete(argumentCaptor.capture());

        Mockito
                .verify(mock)
                .retrieveTodos(programmer);

        final List<String> allValues = argumentCaptor.getAllValues();
        final String[] array = allValues.toArray(new String[0]);
        assertThat(allValues, containsInAnyOrder(array));
    }
}