import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;


public class CopyOnWriteArrayListTest extends CopyOnWriteArrayList<Integer> implements ListeInterface {

    public CopyOnWriteArrayListTest(){
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