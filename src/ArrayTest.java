
public class ArrayTest implements ListeInterface {

    public int[] array;

    public ArrayTest(int size){
        this.array = new int[size];
    }


    
    public int getT(int pos) {
        return this.array[pos];
    }

    public void removeT(int pos){
        int[] res = new int[this.array.length - 1];
        System.arraycopy(this.array, 0, res, 0, pos);
        if (this.array.length != pos) {
            System.arraycopy(this.array, pos + 1, res, pos, this.array.length - pos - 1);
        }
        this.array = res;

    }

    @Override
    public boolean contains(int valeur){
        for(int i = 0 ; i<this.array.length;i++){
            if(valeur==this.array[i])
                return true;
        }
        return false;
    }

    @Override
    public int size(){
        return this.array.length;
    }
}