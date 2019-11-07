package pl.janusz.buchalka.dsa.pt02;

import org.hamcrest.collection.IsArrayContaining;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Janusz Kacki on 23/10/2019. Project; bielmarcus
 */
public class SomeArraysTest {

    private Integer[] array;

    @Before
    public void setUp() throws Exception {

        array = new Integer[2];
    }

    @Test
    public void initialStateOfarray() {

        assertThat(array, is(arrayContaining(nullValue(), nullValue())));

        assertThat(array, hasItemInArray(nullValue()));
    }
}