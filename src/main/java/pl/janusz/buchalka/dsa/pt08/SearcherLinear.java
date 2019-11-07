package pl.janusz.buchalka.dsa.pt08;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class SearcherLinear implements Searcher {

    @Override
    public int search(Integer[] array, Integer key) {

        for (int i = 0; i < array.length; i++) {
            if (key.equals(array[i])) {
                return i;
            }
        }

        return -1;
    }
}
