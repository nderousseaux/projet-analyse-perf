import java.util.HashMap;

public class HashMapTest extends HashMap<Integer, Integer> implements ListeInterface {

    public HashMapTest(){
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
        return super.containsValue(valeur);
    }

    @Override
    public int size(){
        return super.size();
    }
}