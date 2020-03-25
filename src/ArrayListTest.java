import java.util.ArrayList;
import java.util.Collections;


public class ArrayListTest extends ArrayList<Integer> implements ListeInterface {

    public ArrayListTest(){
        super();
    }

    
    public int getT(int pos) {
        return super.get(pos);
    }

    public void removeT(int pos){
        super.remove(pos);
    }

    @Override
    public boolean contains(int valeur){
        return super.contains(valeur);
    }

    @Override
    public int size(){
        return super.size();
    }
}