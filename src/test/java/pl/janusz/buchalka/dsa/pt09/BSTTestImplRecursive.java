package pl.janusz.buchalka.dsa.pt09;

/**
 * Created by Janusz Kacki on 05/11/2019. Project; bielmarcus
 */
public class BSTTestImplRecursive extends BSTTest {

    @Override
    protected BST getTree() {

        return new BinarySearchTreeRecursive<>();
    }
}
