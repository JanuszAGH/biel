package pl.janusz.zooce;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class InsertionSort extends Sorters {

    @Override
    public void sort(Integer[] array) {

        for (int i = 1; i < array.length; i++) {
            int buffer = array[i];
            int slider = i - 1;
            while (slider >= 0 && buffer < array[slider]) {
                array[slider + 1] = array[slider];
                slider--;
            }
            array[slider + 1] = buffer;
        }
    }
}
