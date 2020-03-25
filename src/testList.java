import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class testList {

    //Variables globales
    public static int max = 10000;

    public static void main(String[] args) {
        
        if (args.length != 3) {
            System.out.println("Bad usage of arguments : java testList structure operation taille");
            System.exit(1);
        }

        //On crée la liste
        ListeInterface list = null;

        //On remplit la liste
        switch (args[0]) {
            case "ArrayList":
                list = new ArrayListTest();
                for(int i = 0; i<Integer.parseInt(args[2]); i++){
                    ((ArrayList)list).add(getRandomIntegerInRange(0, max));
                }
                break;

            case "HashMap":
                list = new HashMapTest();
                for(int i = 0; i<Integer.parseInt(args[2]); i++){
                      ((HashMap)list).put(i, getRandomIntegerInRange(0, max));
                 }
                break;

            case "Array":
                list = new ArrayTest(Integer.parseInt(args[2]));
                for(int i = 0; i<Integer.parseInt(args[2]); i++){
                    ((ArrayTest)list).array[i] = getRandomIntegerInRange(0, max);
                }
                break;
            default:
                break;
        }
        
        //On teste l'opération
        switch (args[1]){
            case "getFirst":
                list.getT(0);
                break;

            case "getRandom":
                list.getT(getRandomIntegerInRange(1, list.size())-1);
                break;

            case "getLast":
                list.getT(list.size()-1);
                break;

            case "remove":
                list.removeT(getRandomIntegerInRange(1, list.size())-1);
                break;

            case "contains":
                list.contains(getRandomIntegerInRange(0, max));
                break;

            default:
                break;

        }
    }

    private static int getRandomIntegerInRange(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

}
