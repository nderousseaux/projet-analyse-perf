import java.util.List;

public interface ListeInterface {
    public abstract Integer get(Integer pos);
    public abstract void insert(Integer pos, Integer valeur);
    public abstract void removeAll(Integer valeur);
    public abstract int size();
}
