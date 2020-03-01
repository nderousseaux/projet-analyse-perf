import java.util.ArrayList;
import java.util.Collections;


public class ArrayListTest extends ArrayList<Integer> implements ListeInterface {

    public ArrayListTest(){
        super();
    }

    @Override
    public Integer get(Integer pos) {
        return super.get(pos);
    }

    @Override
    public void insert(Integer pos, Integer valeur){
        super.add(pos, valeur);
    }

    @Override
    public void removeAll(Integer valeur){
        super.removeAll(Collections.singleton(valeur));
    }

    @Override
    public int size(){
        return super.size();
    }
}