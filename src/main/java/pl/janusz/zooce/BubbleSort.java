package pl.janusz.zooce;

/**
 * Created by Janusz Kacki on 05/12/2019. Project; bielmarcus
 */
public class BubbleSort extends Sorters {

    @Override
    public void sort(Integer[] array) {

        int slider = array.length;
        int temp;
        while (slider > 0) {
            for (int i = 0; i < slider - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            slider--;
        }
    }
}
